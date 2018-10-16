package com._27repository;

public class ContactUI {
	
	//List<Contact> repository;
    Repository<Contact> repository;

    public ContactUI(Repository<Contact> repository)
    {
        this.repository = repository;
    }

    public void add(Contact obj)
    {
        repository.add(obj);
    }

    public void remove(Contact obj)
    {
        repository.remove(obj);
    }

    public void printAllContacts()
    {
/*        for (Contact item : repository)
        {
            System.out.println(item);
        }*/
        System.out.println(repository.getAll());

    }


}
