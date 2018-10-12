package com.nenerbener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;


/**
 * Java Program to demonstrate how to do group by in Java 8 using
 * groupingBy() method of Collector class and Stream.

 * @author Javin Paul
 */
public class GroupBy {

    public static void main(String args[]) throws IOException {

//        List<Person> people = new ArrayList<>();
//        people.add(new Person("John", "London", 21));
//        people.add(new Person("Swann", "London", 21));
//        people.add(new Person("Kevin", "London", 23));
//        people.add(new Person("Monobo", "Tokyo", 23));
//        people.add(new Person("Sam", "Paris", 23));
//        people.add(new Person("Nadal", "Paris", 31));
//        
//        // Now let's group all person by city in pre Java 8 world        
//        Map<String,List<Person>> personByCity = new HashMap<>();
//        
//        for(Person p : people){
//            if(!personByCity.containsKey(p.getCity())){
//                personByCity.put(p.getCity(), new ArrayList<>());                
//            }
//            personByCity.get(p.getCity()).add(p);
//        }
//        
//        System.out.println("Person grouped by cities : " + personByCity);
//        
//        // Let's see how we can group objects in Java 8x
//        personByCity =  people.stream()
//                         .collect(Collectors.groupingBy(Person::getCity));
//        System.out.println("Person grouped by cities in Java 8: " 
//                         + personByCity);
//        
//        // Now let's group person by age
//        
//        Map<Integer,List<Person>> personByAge = people.stream()
//                          .collect(Collectors.groupingBy(Person::getAge));
//        System.out.println("Person grouped by age in Java 8: " + personByAge);
    	
    	List<Person> people = new ArrayList<Person>();
    	people.add(new Person("Marc","Kihei",56));
    	people.add(new Person("Dawny","Ningbo",32));
    	people.add(new Person("BB","Montana",1));
    	people.add(new Person("Nena","Texas",2));
    	people.add(new Person("Jerry","Texas",2));
    	
    	Map<String, List<Person>> personsByPlace = new HashMap<>();
    	
    	for (Person p:people) {
    		if (!personsByPlace.containsKey(p.getCity())) {
    			personsByPlace.put(p.getCity(), new ArrayList<Person>());
    		}
    		personsByPlace.get(p.getCity()).add(p);
    	}
    	System.out.println("Persons by location: " + personsByPlace);

		// convert hashmap back to arraylist
		List<Person> listOfPersons = new ArrayList<Person>();
		for (List<Person> lp: personsByPlace.values()) {
			listOfPersons.addAll(lp);
			System.out.println("In " + lp.get(0).getCity() + ": " + lp);
		}
		System.out.println("List of persons: " + listOfPersons);

	}
}

class Person{
    private String name;
    private String city;
    private int age;

    public Person(String name, String city, int age) {
        this.name = name;
        this.city = city;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s(%s,%d)", name, city, age);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + Objects.hashCode(this.city);
        hash = 79 * hash + this.age;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.city, other.city)) {
            return false;
        }
        if (this.age != other.age) {
            return false;
        }
        return true;
    }
    
    
}