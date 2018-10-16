package com._23decorator;

public class TestIceCreamShop {
	public static void main(String[] args) {
		
		IceCream chocolate = new ChocolateIceCream();

        chocolate = new NutsTopping(chocolate);
        chocolate = new GummiesTopping(chocolate);
        chocolate = new FudgeTopping(chocolate);

        chocolate.printDetails();
	}

}
