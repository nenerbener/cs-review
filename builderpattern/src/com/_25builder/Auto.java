package com._25builder;

import java.util.Scanner;

public class Auto implements InsuranceBuilder
{
    Insurance insurance;
    Scanner scanner;

    public Auto()
    {
        this.insurance = new Insurance();
        scanner = new Scanner(System.in);
    }

    public void buildDriver()
    {
        System.out.println("Enter Driver name");
        String driverName = scanner.next();
        System.out.println("Enter Driver age");
        int driverAge = scanner.nextInt();
        //code here may connect to some driver system
        insurance.driver = new Driver(driverName, driverAge);
    }

    public void buildLocation()
    {
    	System.out.println("Enter zipcode");
        String zipcode = scanner.next();
        //code here may connect to some location system

        insurance.location = new Location(zipcode);
    }

    public void buildVehicle()
    {
    	System.out.println("Enter model name");
        String model = scanner.next();
        System.out.println("Enter vehicle year");
        int year = scanner.nextInt();
        //code here may connect to some manufacturer system
        insurance.vehicle = new Vehicle(model, year);
    }

    public Insurance getInsurance()
    {
        if(insurance.driver.age > 25)
        {
            insurance.price = 50.0;
        }
        return insurance;
    }
}
