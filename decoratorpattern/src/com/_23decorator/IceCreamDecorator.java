package com._23decorator;

public class IceCreamDecorator extends IceCream
{
    IceCream topping;

    protected String seperator = ", ";
    
    public IceCreamDecorator(IceCream topping)
    {
        this.topping = topping;
    }
    public String getDescription()
    {
        return topping.getDescription();
    }

    public double cost()
    {
        return topping.cost();
    }
}
