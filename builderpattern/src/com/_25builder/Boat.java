package com._25builder;

import java.util.Scanner;

public class Boat implements InsuranceBuilder
{
    Insurance insurance;
    Scanner scanner;

    public Boat()
    {
        this.insurance = new Insurance();
        scanner = new Scanner(System.in);
    }

    public void buildDriver()
    {
        System.out.println("Enter Captain name");
        String driverName = scanner.next();
        System.out.println("Enter Captain age");
        int driverAge = scanner.nextInt();
        //code here may connect to some driver system
        insurance.driver = new Driver(driverName, driverAge);
    }

    public void buildLocation()
    {
    	System.out.println("Enter Ocean");
        String zipcode = scanner.next();
        //code here may connect to some location system

        insurance.location = new Location(zipcode);
    }

    public void buildVehicle()
    {
    	System.out.println("Enter boat make");
        String model = scanner.next();
        System.out.println("Enter boat year");
        int year = scanner.nextInt();
        //code here may connect to some manufacturer system
        insurance.vehicle = new Vehicle(model, year);
    }

    public Insurance getInsurance()
    {
        return insurance;
    }
}
