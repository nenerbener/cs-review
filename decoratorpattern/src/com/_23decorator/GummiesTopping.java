package com._23decorator;

public class GummiesTopping extends IceCreamDecorator
{
    public GummiesTopping(IceCream topping)
        
    {
    	super(topping);
    }

    public String getDescription()
    {
        return super.getDescription() + seperator + "Gummies";
    }
    
    public double cost()
    {
        return super.cost() + .50;
    }
}
