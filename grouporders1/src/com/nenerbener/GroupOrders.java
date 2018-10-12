package com.nenerbener;
import java.util.List;
import java.util.ArrayList;

public class GroupOrders {

	// driver
	public static void main (String[] args) {

		Item itemA = new Item("A");
		Item itemB = new Item("B");
		Item itemC = new Item("C");
		Item itemD = new Item("D");
		Item itemE = new Item("E");
		
		Order  order1 = new Order("O1");
		Order  order2 = new Order("O2");
		Order  order3 = new Order("O3");
		Order  order4 = new Order("O4");
		
		order1.assocItemToOrder(itemA);
		order1.assocItemToOrder(itemB);
		
		order2.assocItemToOrder(itemB);
		order2.assocItemToOrder(itemC);

		order3.assocItemToOrder(itemD);
		order3.assocItemToOrder(itemD);

		order4.assocItemToOrder(itemD);
		order4.assocItemToOrder(itemE);

		Item it = itemB;
		
		OrderGrp ordGrp = new OrderGrp();
		ordGrp.traverseToOrders(it,null);
	}
}

// traverse graph from starting item and add orders and items found into a group
class OrderGrp {
	List<Order> orders;
	List<Item> items;

	OrderGrp() {
		orders = new ArrayList<Order>();
		items = new ArrayList<Item>();
	}
	
	void traverseToOrders(Item it, Order currentOrder) {
		System.out.println("it: " + it.itemName);
//		System.out.println("traverseToOrder size: " + it.orders.size());
		for(Order or:it.orders) {
			Item currentItem = it;
			if (or.equals(currentOrder)) continue;
			traverseToItems(or, currentItem);
		}
	}

	void traverseToItems(Order or, Item currentItem) {
//		System.out.println("traverseToItems size: " + or.items.size());
		for(Item it:or.items) {
			Order currentOrder = or;
			if (it.equals(currentItem)) continue;
			traverseToOrders(it,currentOrder);
		}
	}
}

// order name and associated list of items
class Order {
	String orderName;
	List<Item> items;

	Order(String orderName) {
		this.orderName = orderName;
	}
	
	void assocItemToOrder(Item it) {
		if (items ==null) {
			items = new ArrayList<Item>();
		}
		items.add(it);
		it.assocOrderToItem(this);
	}
	
}

// item name and associated list of orders
class Item {
	String itemName;
	List<Order> orders;

	Item (String itemName) {
		this.itemName = itemName;
	}

	void assocOrderToItem(Order or) {
		if (orders == null) {
			orders = new ArrayList<Order>();
		}
		orders.add(or);
	}
}