package com._27repository;

public class Contact {
	
	public String name;


    public String toString()
    {
        String temp = "";
        
        if (this instanceof Friend)
        {
            temp = " Friend Name: " + name + " Ph: " + ((Friend)this).phoneNumber;
        }
        else if (this instanceof Work)
        {
            temp = " Work Name: " + name + " Email: " + ((Work)this).email;

        }
        return temp;
    }
}


