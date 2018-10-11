package com.nenerbener;
import java.util.List;
import java.util.ArrayList;

public class GroupOrders {

	// driver
	public static void main (String[] args) {

		String item1 = "A";
		String item2 = "B";
		String item3 = "C";
		String item4 = "D";
//		String[] items = new String[4];
//		items[0]=item1;
//		items[1]=item2;
//		items[2]=item3;
//		items[3]=item4;
		
		List<String> itl1 = new ArrayList<String>();
		itl1.add(item1);
		itl1.add(item2);
		Order order1 = new Order("O1", itl1);
		
		List<String> itl2 = new ArrayList<String>();
		itl2.add(item2);
		itl2.add(item3);
		Order order2 = new Order("O2", itl2);
		
		List<String> itl3 = new ArrayList<String>();
		itl3.add(item3);
		itl3.add(item4);
		Order order3 = new Order("O3", itl3);
		
		List<Order> orders = new ArrayList<Order>();
		orders.add(order1);
		orders.add(order2);
		orders.add(order3);
		
		itl1.retainAll(itl2);
		System.out.println(itl1);
		itl2.retainAll(itl3);
		System.out.println(itl2);

	}
	
}

// order has order number and number of items
class Order {
	String orderNum;
	List<String> items;
	Order(String orderNum, List<String> items) {
		this.orderNum = orderNum;
		this.items = items;
	}
	
}