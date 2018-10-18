package com.nenerbener;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Stack;

//import com.journaldev.xml.Employee;

public class XMLParserSAX {

    public static void main(String[] args) {
    SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
    try {
        SAXParser saxParser = saxParserFactory.newSAXParser();
        MyHandler handler = new MyHandler();
        saxParser.parse(new File("data/employees.xml"), handler);
        //Get Employees list
        List<Employee> empList = handler.getEmpList();
        //print employee information
        for(Employee emp : empList)
            System.out.println(emp);
    } catch (ParserConfigurationException | SAXException | IOException e) {
        e.printStackTrace();
    }
    }

}

class MyHandler extends DefaultHandler {

    private Stack<String> elementStack = new Stack<String>();
    private Stack<Object> objectStack  = new Stack<Object>();
    private Employee myEmp = null;

    //List to hold Employees object
    private List<Employee> empList = null;
    private Employee emp = null;


    //getter method for employee list
    public List<Employee> getEmpList() {
        return empList;
    }

    boolean bAge = false;
    boolean bName = false;
    boolean bGender = false;
    boolean bRole = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {

        this.elementStack.push(qName); //push onto my element stack

        if (qName.equalsIgnoreCase("Employee")) {
            //create a new Employee and put it in Map
            String id = attributes.getValue("id");
            //initialize Employee object and set id attribute
            emp = new Employee();
            emp.setId(Integer.parseInt(id));
            //initialize list
            if (empList == null)
                empList = new ArrayList<>();
            this.myEmp = new Employee();
            this.objectStack.push(myEmp); // create an employee and push onto my object stack
        } else if (qName.equalsIgnoreCase("name")) {
            //set boolean values for fields, will be used in setting Employee variables
            bName = true;
        } else if (qName.equalsIgnoreCase("age")) {
            bAge = true;
        } else if (qName.equalsIgnoreCase("gender")) {
            bGender = true;
        } else if (qName.equalsIgnoreCase("role")) {
            bRole = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        System.out.println("myObj: " + this.elementStack.pop()); //pop from my element stack

        if (qName.equalsIgnoreCase("Employee")) {
            //add Employee object to list
            empList.add(emp);
            System.out.println("myEmp: " + this.objectStack.pop()); // pop from my object stack and print
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {

        if (bAge) {
            //age element, set Employee age
            emp.setAge(Integer.parseInt(new String(ch, start, length)));
            bAge = false;
            myEmp.setAge(Integer.parseInt(new String(ch, start, length)));
        } else if (bName) {
            emp.setName(new String(ch, start, length));
            bName = false;
            myEmp.setName(new String(ch, start, length));
        } else if (bRole) {
            emp.setRole(new String(ch, start, length));
            bRole = false;
            myEmp.setRole(new String(ch, start, length));
        } else if (bGender) {
            emp.setGender(new String(ch, start, length));
            bGender = false;
            myEmp.setGender(new String(ch, start, length));
        }
    }
}

class Employee {
    private int id;
    private String name;
    private String gender;
    private int age;
    private String role;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    
    @Override
    public String toString() {
        return "Employee:: ID="+this.id+" Name=" + this.name + " Age=" + this.age + " Gender=" + this.gender +
                " Role=" + this.role;
    }
    
}