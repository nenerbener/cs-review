package com.nenerbener;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


public class AmazonSort2 {

	public static void main (String[] args) {
		
		
		int[] iArray = new int[10];
		for (int k = 0; k < iArray.length; k++) {
			int i = iArray[k];
			System.out.print(iArray);
		}
		for (int i:iArray) System.out.print(iArray[i]);
		System.out.println();
		Integer[] jArray = new Integer[10];
		for (Integer j:jArray) System.out.print(jArray[j]);
		System.out.println();
		
		// read in # coins
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter number of slots: ");
		String numSlotsString = scanner.nextLine();
		int numSlots = Integer.decode(numSlotsString);
		
		System.out.print("Enter number of coins: ");
		String numCoinsString = scanner.nextLine();
		int numCoins = Integer.decode(numCoinsString);//		Integer[] jArray = new Integer[10];
//		for (Integer j:jArray) System.out.print(jArray[j]);
//		System.out.println();

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
			outerloop: {//		Integer[] jArray = new Integer[10];
//			for (Integer j:jArray) System.out.print(jArray[j]);
//			System.out.println();

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
					int i2 = i - 1;//
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
	}
}

class CoinArray implements Coins<Integer>
{
	List<Integer> coins = new ArrayList<Integer>();
//	List<Integer> coins;
	
	public CoinArray(int numSlots) {
//		Integer[] array = new Integer[numSlots];
//		for (int j = 0; j < array.length; j++) {
		for (int j = 0; j < numSlots; j++) {
//			array[j]= new Integer(0);
			coins.add(new Integer(0));
		}
//		coins = new ArrayList<Integer>(Arrays.asList(array)) ;
	}

	@Override
	public void add(int i) {
//		coins.set(i, coins.get(i)+1);
		Integer setCoin = new Integer(coins.get(i).intValue()+1);
		coins.set(i,setCoin);
	}

	@Override
	public void remove(Integer coin) {
		coins.remove(coin);
	}

	@Override
	public int size() {
		return coins.size();
	}

	@Override
	public String getAll() {
		return coins.toString();
	}

	@Override
	public Integer get(int i) {
		return coins.get(i);
	}

	@Override
	public void set(int i, Integer coin) {
		coins.set(i, coin);
	}
}

interface Coins<T> {
	void add(int i);
	void remove(T coin);
	int size();
	String getAll();
	T get(int i);
	void set(int i, T coin);
}
