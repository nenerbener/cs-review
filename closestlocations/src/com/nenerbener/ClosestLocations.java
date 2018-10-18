package com.nenerbener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Comparator;


public class ClosestLocations {

	public static void main(String[] argsv) {
		ClosestLocations cl = new ClosestLocations();
		Integer[][] intArray = 
			   {{new Integer(3),new Integer(3)},
				{new Integer(2),new Integer(2)},
				{new Integer(1),new Integer(1)}};
		List<Integer[]> list = Arrays.asList(intArray);
		System.out.println("list: " + intArray);
		List<PQObject> results = cl.getNearestLocations(list);
		for (PQObject obj:results) {
			System.out.print("r: " + obj.getI() + " ");
			System.out.print("x: " + obj.getList()[0] + " ");
			System.out.println("y: " + obj.getList()[1]);
		}
	}

	List<PQObject> getNearestLocations(List<Integer[]> list)
	{
		List<PQObject> result = new ArrayList<>();
		PriorityQueue<PQObject> pq = new PriorityQueue<>(100, new Comparator<PQObject>() {
			@Override
			public int compare(PQObject a1, PQObject a2) {
				return Integer.compare(a1.getI().intValue(), a2.getI().intValue());
			}
		});	
		for (Integer[] elem: list) {
			PQObject obj = new PQObject(); 
			obj.set(elem[0]*elem[0]+elem[1]*elem[1], elem);
			pq.add(obj);
		}
		while (!pq.isEmpty()) result.add(pq.remove());
		return result;
	}
}

class PQObject implements PQElement<Integer,Integer[]>{
	Integer i;
	Integer[] li;
	@Override
	public void set(Integer i, Integer[] ta) {
		this.i = i;
		this.li = ta;
	}
	@Override
	public Integer[] getList() {
		return li;
	}
	@Override
	public Integer getI() {
		return i;
	}
}

interface PQElement<Integer,T2> {
	void set(Integer i, T2 ta); //add
	T2 getList(); //get the object with the integer
	Integer getI(); //get the object with the integer
}