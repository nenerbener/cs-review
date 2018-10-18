package com.nenerbener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.AbstractQueue; 
//AbstractQueue is concrete base class for many queues ( 
//ArrayBlockingQueue, ConcurrentLinkedQueue, DelayQueue, LinkedBlockingDeque
//LinkedBlockingQueue, LinkedTransferQueue, PriorityBlockingQueue, PriorityQueue, SynchronousQueue

public class ClosestLocations {

	public static void main(String[] argsv) {
		ClosestLocations cl = new ClosestLocations();
		Integer[][] intArray = 
			   {{new Integer(3),new Integer(3)},
				{new Integer(1),new Integer(1)},
				{new Integer(2),new Integer(2)}};
		
		System.out.println(Arrays.toString(intArray[0]));
		System.out.println(Arrays.toString(intArray[1]));
		System.out.println(Arrays.toString(intArray[2]));
		
		List<Integer[]> list = Arrays.asList(intArray);
		List<PQObject> results = cl.getNearestLocations(list);
		System.out.println(results);
	}

	List<PQObject> getNearestLocations(List<Integer[]> list)
	{
		List<PQObject> result = new ArrayList<>();
		QueueFactory qf = new QueueFactory();
		Comparator<PQObject> cpq = new Comparator<PQObject>() {
			@Override
			public int compare(PQObject a2, PQObject a1) {
				return Integer.compare(a1.getI().intValue(), a2.getI().intValue());
			}
		};

		AbstractQueue<PQObject> pq = (PriorityQueue<PQObject>)qf.getQueue("PriorityQueue",100,cpq);

//		AbstractQueue<PQObject> pq = new PriorityQueue<>(100, new Comparator<PQObject>() {
//			@Override
//			public int compare(PQObject a1, PQObject a2) {
//				return Integer.compare(a1.getI().intValue(), a2.getI().intValue());
//			}
//		});	

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
	@Override
	public String toString() {
		return "r2:" + this.i + " row:" + this.getList()[0] + " col:" + this.getList()[1];
	}
}

interface PQElement<T1,T2> {
	void set(T1 i, T2 ta); //add
	T2 getList(); //get the object with the integer
	T1 getI(); //get the object with the integer
	String toString(); //get the object with the integer
}

class QueueFactory implements QueueFactoryInterface<PQObject> {
	QueueFactory(){};
	
	@Override
	public AbstractQueue<PQObject> getQueue(String queueType) {
		if (queueType.equals("PriorityQueue")) return new PriorityQueue<PQObject>();
		else return null;
	}

	@Override
	public AbstractQueue<PQObject> getQueue(String queueType, int size, Comparator<PQObject> c) {
		if (queueType.equals("PriorityQueue")) return new PriorityQueue<PQObject>(100, c);
		else return null;
	}
}

interface QueueFactoryInterface<QT> {
	AbstractQueue<QT> getQueue(String queueType);
	AbstractQueue<QT> getQueue(String queueType, int size, Comparator<QT> c);
}