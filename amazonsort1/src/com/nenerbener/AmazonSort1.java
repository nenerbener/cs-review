package com.nenerbener;

import java.util.*;
import java.lang.Math;

public class AmazonSort1 {

	public static void main (String[] args) {
		
		// read in # coins
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter number of slots: ");
		String numSlotsString = scanner.nextLine();
		System.out.println("numSlotsString: " + numSlotsString);
		
		int numSlots = Integer.decode(numSlotsString);
		System.out.println("numSlots: " + numSlots);
		System.out.println("---");
		
		System.out.print("Enter number of coins: ");
		String numCoinsString = scanner.nextLine();
		System.out.println("numCoinsString: " + numCoinsString);
		scanner.close();
		
		int numCoins = Integer.parseInt(numCoinsString);
		System.out.println("numCoins: " + numCoins);
		System.out.println("---");
		
		//generate random # of coins in slots
		int[] coinArray = new int[numSlots];
		for (int i = 0; i<numCoins;i++) {
			int ranInt = (int) (Math.random() * numSlots);
//			System.out.println("i ranInt: " + i + "/" + ranInt);
			coinArray[ranInt]++;
		}

		printCoinArray(coinArray); //print inital coinArray
        // mark all the vertices 
//      Vertex A = new Vertex("A");
//      Vertex B = new Vertex("B");
//      Vertex D = new Vertex("D");
//      Vertex F = new Vertex("F");
//      Vertex K = new Vertex("K");
//      Vertex J = new Vertex("J");
//      Vertex M = new Vertex("M");
//      Vertex O = new Vertex("O");
//      Vertex P = new Vertex("P");
//      Vertex R = new Vertex("R");
//      Vertex Z = new Vertex("Z");

      // set the edges and weight
//      A.adjacencies = new Edge[]{ new Edge(M, 8) };
//      B.adjacencies = new Edge[]{ new Edge(D, 11) };
//      D.adjacencies = new Edge[]{ new Edge(B, 11) };
//      F.adjacencies = new Edge[]{ new Edge(K, 23) };
//      K.adjacencies = new Edge[]{ new Edge(O, 40) };
//      J.adjacencies = new Edge[]{ new Edge(K, 25) };
//      M.adjacencies = new Edge[]{ new Edge(R, 8) };
//      O.adjacencies = new Edge[]{ new Edge(K, 40) };
//      P.adjacencies = new Edge[]{ new Edge(Z, 18) };
//      R.adjacencies = new Edge[]{ new Edge(P, 15) };
//      Z.adjacencies = new Edge[]{ new Edge(P, 18) };

		// 1. iterate through array left to right 
		// 	  keeping track of open slots (s0) and next pos. that has at least 2 coins (s2)
		// 2. find open slot(s0)
		// 3. iterate from s0 and find next position that has at least 2 coins (s2)
		// 4. move 1 coin from s2 to s0
		// 5. move back to s0+1, return to step 2
		// 6. reverse array and repeat
		
		for (int i=0; i<coinArray.length-1;i++) {
			outerloop: {
				int s0=coinArray[i];
				if (s0==0) { //find s0
					int i2 = i + 1;
					for (int j=i2; j<coinArray.length;j++) {
						if (coinArray[j]>=2) { //find s2
							coinArray[i]++;
							coinArray[j]--;
							break outerloop;
						}
					}
				}
			}
		}
		
		printCoinArray(coinArray); //print inital coinArray

		// now do the same algorithm in reverse
		for (int i=coinArray.length-1; i>0;i--) {
			outerloop: {
				int s0=coinArray[i];
				if (s0==0) { //find s0
					int i2 = i - 1;
					for (int j=i2; j>=0;j--) {
						if (coinArray[j]>=2) { //find s2
							coinArray[i]++;
							coinArray[j]--;
							break outerloop;
						}
					}
				}
			}
		}
		
		printCoinArray(coinArray); //print inital coinArray

		System.exit(0);
	}
	
	public static void printCoinArray(int[] coinArray)
	{
		
		// check coinArray for correctness
		for (int i = 0; i<coinArray.length;i++) {
			System.out.println("coinArray[" + i + "]: " + coinArray[i]);
		}
		System.out.println("---");

	}
}
