package com.nenerbener;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class GroupOrders {

	// driver
	public static void main (String[] args) {

		// create item list
		Item itemA = new Item("A");
		Item itemB = new Item("B");
		Item itemC = new Item("C");
		Item itemD = new Item("D");
		Item itemE = new Item("E");
		Item itemF = new Item("F");
		Item itemG = new Item("G");
		Item itemH = new Item("H");
		List<Item> itemList = new ArrayList<>();

		itemList.add(itemA);
		itemList.add(itemB);
		itemList.add(itemC);
		itemList.add(itemD);
		itemList.add(itemE);
		itemList.add(itemF);
		itemList.add(itemG);
		itemList.add(itemH);
		
		// create orders
		Order  order1 = new Order("O1");
		Order  order2 = new Order("O2");
		Order  order3 = new Order("O3");
		Order  order4 = new Order("O4");
		List<Order> orderList = new ArrayList<>();
		orderList.add(order1);
		orderList.add(order2);
		orderList.add(order3);
		orderList.add(order4);
		
		// associate items to orders
		order1.assocItemToOrder(itemA);
		order1.assocItemToOrder(itemB);

		order2.assocItemToOrder(itemC);
		order2.assocItemToOrder(itemD);
		order2.assocItemToOrder(itemE);

		order3.assocItemToOrder(itemF);
		order3.assocItemToOrder(itemG);

		order4.assocItemToOrder(itemH);
		order4.assocItemToOrder(itemA);

		// iterate through items and build connected items
		OrderGrp ordGrp = new OrderGrp();
		List<Order> traversedOrders = new ArrayList<>();
		for (Order or:orderList) {
			if (!traversedOrders.contains(or)) {
				ordGrp.traverseToItems(or,null);
			}
			traversedOrders.addAll(ordGrp.getOrders());
			System.out.println(ordGrp);
			traversedOrders.clear();
			ordGrp.getOrders().clear();
		}
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

//		if(currentOrder==null) System.out.println("it: " + it.itemName);
//		else System.out.println("currentOrder it: " + currentOrder.orderName + " " + it.itemName);
//		if (currentOrder != null) orders.add(currentOrder);
		items.add(it);
		for(Order or:it.orders) {
			Item currentItem = it;
			if (or.equals(currentOrder)) continue;
			traverseToItems(or, currentItem);
		}
	}

	void traverseToItems(Order or, Item currentItem) {
		orders.add(or);
		for(Item it:or.items) {
			Order currentOrder = or;
			if (it.equals(currentItem)) continue;
			traverseToOrders(it,currentOrder);
		}
	}
	
	List<Order> getOrders() {
		return orders;
	}
	
	List<Item> getItems() {
		return items;
	}
	
	public String toString() {
		StringBuilder strbld = new StringBuilder("group[ ");
	
		for (Order grpOrder:orders) {
			strbld.append(grpOrder.orderName).append(": ");
			for (Item it:grpOrder.items) {
					strbld.append(it.itemName).append(" ");
			}
		}
		strbld.append("]");
		return strbld.toString();
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