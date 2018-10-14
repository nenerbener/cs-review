package com.nenerbener;

public class MultipleNotificationSystems {

	public static void main(String[] args) throws InterruptedException {
		NotificationSystem ns1 = new NotificationSystem();
		NotificationSystem ns2 = new NotificationSystem();
		System.out.println("before ns1");
		String[] args1 = {"","ns1"};
		String[] args2 = {"","ns2"};
		ns1.main(args1);
		System.out.println("before ns2");
		ns2.main(args2);
	}

}