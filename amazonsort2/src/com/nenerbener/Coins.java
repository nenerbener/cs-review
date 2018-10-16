package com.nenerbener;

public interface Coins<T> {
	void add(int i);
	void remove(T coin);
	int size();
	String getAll();
	Integer get(int i);
	void set(int i, T coin);
}
