package com._27repository;

public class TestRepository {

	public static void main(String[] args) {
		
		//List<Contact> repository = new ArrayList<Contact>();
        //Repository repository = new InMemoryListRepository();
		Repository repository = new TextFileRepository();
        ContactUI contactui = new ContactUI(repository);

        Contact contact1 = new Friend();  
        contact1.name = "Alex"; 
        ((Friend)contact1).phoneNumber = "555";
        
        Contact contact2 = new Work();
        contact2.name = "Sara";
         ((Work)contact2).email = "sara@geico";

        contactui.add(contact1);
        contactui.add(contact2);
        contactui.printAllContacts();

	}

}
