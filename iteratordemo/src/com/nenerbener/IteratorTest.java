package com.nenerbener;

import java.util.*;
public class IteratorTest {

   public static void main(String args[]) {
      // Create an array list
      List<String> al = new ArrayList<>();
      
      // add elements to the array list
      al.add("C");
      al.add("A");
      al.add("E");
      al.add("B");
      al.add("D");
      al.add("F");

      // Use iterator to display contents of al
      System.out.print("Original contents of al: ");
      Iterator<String> itr = al.iterator();
      
      while(itr.hasNext()) {
         String element = (String) itr.next();
         System.out.print(element + " ");
      }
      System.out.println();
      
      // Modify objects being iterated
      ListIterator<String> litr = al.listIterator();
      
      while(litr.hasNext()) {
         Object element = litr.next();
         litr.set(element + "+");
      }
      System.out.print("Modified contents of al: ");
      itr = al.iterator();
      
      while(itr.hasNext()) {
         Object element = itr.next();
         System.out.print(element + " ");
      }
      System.out.println();

      // Now, display the list backwards using previous (must have cursor set at List.size()
      System.out.print("Modified list backwards using hasPrevious: ");
      
      while(litr.hasPrevious()) {
         Object element = litr.previous();
         System.out.print(element + " ");
      }
      System.out.println();
      
      // reverse list using Collections.reverse()
      Collections.reverse(al);
      itr = al.iterator();
      
      System.out.print("Modified list backwards using Utility function: ");

      while(itr.hasNext()) {
         Object element = itr.next();
         System.out.print(element + " ");
      }
      System.out.println();
      
   }
}