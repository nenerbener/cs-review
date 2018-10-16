package com._25builder;

public class Vehicle {
	
	String model;
    int year;
    
    public Vehicle(String model, int year)
    {
        this.model = model;
        this.year = year;
    }

    public String toString()
    {
        return this.model + "(" + this.year + ")";

    }

}
