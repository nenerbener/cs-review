package com._25builder;

public class Driver {
	
	private String name;
    public int age;

    public Driver(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public String toString()
    {
        return this.name + "(" + this.age + ")";

    }

}
