package com.nenerbener;
import java.util.*;

class CoinArray implements Coins<Integer>
{
	List<Integer> coins = new ArrayList<Integer>();
//	List<Integer> coins;
	
	public CoinArray(int numSlots) {
		Integer[] array = new Integer[numSlots];
		for (int j = 0; j < array.length; j++) {
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