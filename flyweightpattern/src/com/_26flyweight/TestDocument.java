package com._26flyweight;

import java.util.Scanner;

public class TestDocument {
	
	public static void main(String[] args) {
    
        Document doc1 = new Document();
        
        Scanner scanner = new Scanner(System.in);
        String x=null;
        do 
        {
            x = scanner.nextLine();
            if(x.equals("")) {break;}
            doc1.typeLetter(x.charAt(0));
        } while(x != "" );

        System.out.println("\n"); 
        doc1.process();
        doc1.report();

    }

}
