package com._23decorator;


public class NutsTopping extends IceCreamDecorator
{
    public NutsTopping(IceCream topping)
        
    {
    	super(topping);
    }

    public String getDescription()
    {
        return super.getDescription() + seperator + "Nuts";
    }
    
    public double cost()
    {
        return super.cost() + .75;
    }
}
