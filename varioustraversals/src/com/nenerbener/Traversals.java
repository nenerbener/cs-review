package com.nenerbener;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Traversals {

	public static void main(String[] args) {

		final String blank = " ";
		
		{
			Integer[][] intArray = 
					{{1, 1, 1, 1},
					{0, 1, 0, 1},
					{0, 1, 0, 1},
					{0, 1, 9, 1}};
			
			for (int j=0; j<intArray.length; j++) {
				for (int i=0; i<intArray.length; i++) {
					System.out.print(intArray[j][i] + blank);
				}
				System.out.println();
			}
			System.out.println();
		}
		
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
				for (Integer i: j) {
					System.out.print(i + blank);
				}
				System.out.println();
			}
		}
		
		{
			int[] intArray = {9,8,7,6,5,4,3,2,1};
			Arrays.sort(intArray);
			System.out.println(Arrays.toString(intArray));
		}
		
		{
			int[][] intArray = {{9,8},{7,6},{5,4},{3,2},{1,0}};
			Arrays.sort(intArray, 
				new Comparator<int[]>() {
					@Override
					public int compare(int[] o1, int[] o2) {
						return Integer.compare(o2[0],o1[0]);
					}	
				}
			);	
			
			for (int[] i:intArray) {
				System.out.println(Arrays.toString(i));
			}
		}
	}
}
