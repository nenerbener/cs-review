package com.nenerbener;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ArraysAndLists {

	public static void main(String[] args) {

		final String blank = " ";
		
		// create an Integer[][] and pretty print with Arrays.toString()
		{
			Integer[][] intArray = 
					{{1, 1, 1, 1},
					{0, 1, 0, 1},
					{0, 1, 0, 1},
					{0, 1, 9, 1}};
			
			// convert to <List<Integer[]>
			List<Integer[]> a = Arrays.asList(intArray);
			
			// use java.util.Arrays to pretty print each row which is Integer[]
			System.out.println("Integer[][] -> List<Integer[]> for printing");
			for (Integer[] i: a) System.out.println(Arrays.toString(i));
			System.out.println();
		}
		
		//Java8 way of converting from Integer[][] to List<List<Integer>>,
		//then pretty print using Arrays.toString(List.toArray())
		{
			Integer[][] intArray = 
					{{1, 1, 1, 1},
					{0, 1, 0, 1},
					{0, 1, 0, 1},
					{0, 1, 9, 1}};
			
			List<List<Integer>> list = Arrays.stream(intArray)
									   .map(Arrays::asList)
									   .collect(Collectors.toList());
			for (List<Integer> j: list) {
				System.out.println(Arrays.toString(j.toArray()));
			}
		}
		
		// sorting int[] using Array.sort()
		{
			int[] intArray = {9,8,7,6,5,4,3,2,1};
			Arrays.sort(intArray);
			System.out.println(Arrays.toString(intArray));
		}
		
		// sorting a 2 dimensional array based on the rows 1st elemeent
		// caparator algorithm if in compare(p1,p1), p1>p2 flip obj(p1) and obj(p2)
		// change the row elements to List<int[]>, use Arrays.toString() to pretty print
		{
			int[][] intArray = {{9,8},{5,6},{7,4},{3,2},{1,0}};
			List<int[]> list = Arrays.asList(intArray);
			for (int[] i:list) System.out.println(Arrays.toString(i));
			Arrays.sort(intArray, 
				new Comparator<int[]>() {
					@Override
					public int compare(int[] o1, int[] o2) {
						return Integer.compare(o1[0],o2[0]);
					}	
				}
			);	
			
			for (int[] i:intArray) {
				System.out.println(Arrays.toString(i));
			}
		}
	}
}
