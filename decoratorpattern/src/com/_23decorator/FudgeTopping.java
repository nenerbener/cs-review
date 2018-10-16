package com._23decorator;

public class FudgeTopping extends IceCreamDecorator
{
    public FudgeTopping(IceCream topping)
        
    {
    	super(topping);
    }

    public String getDescription()
    {
        return super.getDescription() + seperator + "Fudge";
    }
    
    public double cost()
    {
        return super.cost() + .25;
    }
}
