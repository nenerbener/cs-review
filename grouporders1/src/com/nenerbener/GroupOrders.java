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
		
		List<String> itl1 = new ArrayList<String>();
		itl1.add(item1);
		itl1.add(item2);
		Order order1 = new Order(1, itl1);
		
		List<String> itl2 = new ArrayList<String>();
		itl2.add(item3);
		itl2.add(item4);
		Order order2 = new Order(2, itl2);
		
		List<String> itl3 = new ArrayList<String>();
		itl3.add(item3);
		itl3.add(item4);
		Order order3 = new Order(3, itl3);
		
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
	long orderNum;
	List<String> items;
	Order(long orderNum, List<String> items) {
		this.orderNum = orderNum;
		this.items = items;
	}
	
}