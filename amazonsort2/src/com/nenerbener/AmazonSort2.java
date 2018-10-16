package com.nenerbener;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


public class AmazonSort2 {

	public static void main (String[] args) {
		
		// read in # coins
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter number of slots: ");
		String numSlotsString = scanner.nextLine();
		int numSlots = Integer.decode(numSlotsString);
		
		System.out.print("Enter number of coins: ");
		String numCoinsString = scanner.nextLine();
		int numCoins = Integer.decode(numCoinsString);
//		int numCoins = Integer.parseInt(numCoinsString);
		scanner.close();
		
		//generate random # of coins in slots
		Coins<Integer> coins = new CoinArray(numSlots);
		for (int i = 0; i<numCoins;i++) {
			int ranInt = (int) (Math.random() * numSlots);
			coins.add(ranInt);
		}

		System.out.println(coins.getAll()); //print inital coinArray

		// 1. iterate through array left to right 
		// 	  keeping track of open slots (s0) and next pos. that has at least 2 coins (s2)
		// 2. find open slot(s0)
		// 3. iterate from s0 and find next position thaxt has at least 2 coins (s2)
		// 4. move 1 coin from s2 to s0
		// 5. move back to s0+1, return to step 2
		// 6. reverse array and repeat
		
		for (int i=0; i<coins.size()-1;i++) {
			outerloop: {
				int s0=coins.get(i).intValue();
				if (s0==0) { //find s0
					int i2 = i + 1;
					for (int j=i2; j<coins.size();j++) {
						if (coins.get(j).intValue()>=2) { //find s2
							Integer coin = coins.get(i);
							coin = new Integer(coin.intValue()+1);
							coins.set(i,coin);
							coin = coins.get(j);
							coin = new Integer(coin.intValue()-1);
							coins.set(j,coin);
							break outerloop;
						}
					}
				}
			}
		}
		
		System.out.println(coins.getAll());

		for (int i=coins.size()-1;i>0;i--) {
			outerloop: {
				int s0=coins.get(i).intValue();
				if (s0==0) { //find s0
					int i2 = i - 1;
					for (int j=i2; j>=0;j--) {
						if (coins.get(j).intValue()>=2) { //find s2
							Integer coin = coins.get(i);
							coin = new Integer(coin.intValue()+1);
							coins.set(i,coin);
							coin = coins.get(j);
							coin = new Integer(coin.intValue()-1);
							coins.set(j,coin);
							break outerloop;
						}
					}
				}
			}
		}
		
		System.out.println(coins.getAll());
//
//		// now do the same algorithm in reverse
//		for (int i=coinArray.length-1; i>0;i--) {
//			outerloop: {
//				int s0=coinArray[i];
//				if (s0==0) { //find s0
//					int i2 = i - 1;
//					for (int j=i2; j>=0;j--) {Integer
//						if (coinArray[j]>=2) { //find s2
//							coinArray[i]++;interface CoinArray<T> {
//								void add(T coin);
//								void remove(T coin);
//								String getAll();
//							}
//							coinArray[j]--;
//							break outerloop;
//						}
//					}
//				}java Integer class
//			}
//		}
//		
//		printCoinArray(coinArray); //print inital coinArray

	}
}


