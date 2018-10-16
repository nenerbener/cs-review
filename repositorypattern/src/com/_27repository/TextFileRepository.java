package com._27repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextFileRepository implements Repository<Contact>
{
    //list pointing to text file
    String path = "c:\\temp\\MyTextDatabase.txt";
    public void add(Contact obj)
    {
        //write to text file
    	FileWriter writer;
    	try {
    		writer = new FileWriter(path, true);
			writer.write(obj.toString());
			writer.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
        
    }

    public String getAll()
    {
        //get info from text file
        String temp = "";
        try {
        	FileReader reader = new FileReader(path);

            BufferedReader bufferreader = new BufferedReader(reader);

            String line;
            while ((line = bufferreader.readLine()) != null) {     
            	temp += line;
            }
            reader.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return temp;
    }

    public void remove(Contact obj)
    {
        //remove from text file
    }
}
