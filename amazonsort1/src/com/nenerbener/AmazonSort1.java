package com.nenerbener;

import java.util.*;
import java.lang.Math;

public class AmazonSort1 {

	public static void main (String[] args) {
		
		short[] slots;
		
		// read in # coins
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter number of coins: ");
		String numCoinString = scanner.nextLine();
		System.out.println("numCoinString: " + numCoinString);
		scanner.close();
		
		int numCoins = Integer.parseInt(numCoinString);
		System.out.println("numCoins: " + numCoins);
		System.out.println("---");
		
		//generate random # of coins in slots
		int[] coinArray = new int[numCoins];
		for (int i = 0; i<coinArray.length;i++) {
			int ranInt = (int) (Math.random() * 10);
//			System.out.println("i ranInt: " + i + "/" + ranInt);
			coinArray[ranInt]++;
		}

		printCoinArray(coinArray); //print inital coinArray

		// 1. iterate through array left to right 
		// 	  keeping track of open slots (s0) and next pos. that has at least 2 coins (s2)
		// 2. find open slot(s0)
		// 3. iterate from s0 and find next position that has at least 2 coins (s2)
		// 4. move 1 coin from s2 to s0
		// 5. move back to s0+1, return to step 2
		// 6. reverse array and repeat
		
		for (int i=0; i<coinArray.length-1;i++) {
			outerloop: {
				int s0=coinArray[i];
				if (s0==0) { //find s0
					int i2 = i + 1;
					for (int j=i2; j<coinArray.length;j++) {
						if (coinArray[j]>=2) { //find s2
							coinArray[i]++;
							coinArray[j]--;
							break outerloop;
						}
					}
				}
			}
		}
		
		printCoinArray(coinArray); //print inital coinArray

		for (int i=coinArray.length-1; i>0;i--) {
			outerloop: {
				int s0=coinArray[i];
				if (s0==0) { //find s0
					int i2 = i - 1;
					for (int j=i2; j>=0;j--) {
						if (coinArray[j]>=2) { //find s2
							coinArray[i]++;
							coinArray[j]--;
							break outerloop;
						}
					}
				}
			}
		}
		
		printCoinArray(coinArray); //print inital coinArray

		System.exit(0);
	}
	
	public static void printCoinArray(int[] coinArray)
	{
		
		// check coinArray for correctness
		for (int i = 0; i<coinArray.length;i++) {
			System.out.println("coinArray[" + i + "]: " + coinArray[i]);
		}
		System.out.println("---");

	}
}
