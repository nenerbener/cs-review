package com._27repository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryListRepository implements Repository<Contact>
{
    List<Contact> contacts = new ArrayList<Contact>();
    
    public void add(Contact obj)
    {
        contacts.add(obj);
    }


    public void remove(Contact obj)
    {
        contacts.remove(obj);
    }
    
    public String getAll()
    {
        String temp = "";
        for (Contact contact : contacts)
        {
            temp += contact + "\n";
        }
        return temp;
    }
}

