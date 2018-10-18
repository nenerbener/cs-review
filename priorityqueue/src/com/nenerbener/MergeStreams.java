package com.nenerbener;

import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Comparator;

public class MergeStreams {

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(mergeStreams(
//                new int[][] { { 2, 4, 5, 6, 7, 8 },
//                        { 1, 3, 9, 12 },
//                        { 10, 11, 13, 14 } })));
    	int [][] streams = {{13,15,18,20,23},
    			{11,13,18,19,21},
    			{17,19,22,25,27,30}};
    	int [] result = mergeStreams(streams);
    	System.out.println(Arrays.toString(result));
    }

//    private static int[] mergeStreams(int[][] is) {
//        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
//        for (int i = 0; i < is.length; i++) {
//            for (int j = 0; j < is[i].length; j++)
//                pq.add(is[i][j]);
//        }
//        int[] result = new int[pq.size()];
//        int counter = 0;
//        Iterator<Integer> i = pq.iterator();
//        while (i.hasNext()) {
//            result[counter++] = pq.remove();
//        }
//        return result;
//    }

    private static int[] mergeStreams(int[][] is) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(100,
        	new Comparator<Integer> () {
        		public int compare(Integer x, Integer y) {
					if (x < y)
					{
						return 1;
					}
					if (x > y)
					{
						return -1;
					}
					return 0;
        		}
        	}
        );
        for (int i = 0; i < is.length; i++) {
            for (int j = 0; j < is[i].length; j++)
                pq.add(is[i][j]);
        }
        int[] result = new int[pq.size()];
        int counter = 0;
        Iterator<Integer> i = pq.iterator();
        while (i.hasNext()) {
            result[counter++] = pq.remove();
        }
        return result;
    }
}