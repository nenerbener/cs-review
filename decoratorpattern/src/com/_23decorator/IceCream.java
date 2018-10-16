package com._23decorator;

public abstract class IceCream {
	
	public abstract String getDescription();
    public abstract double cost();

    public void printDetails()
    {
        System.out.println(" Cost : " + this.cost() + ", Description : " + this.getDescription());
    }

}
