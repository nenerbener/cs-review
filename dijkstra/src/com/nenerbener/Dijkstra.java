package com.nenerbener;

import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Vertex implements Comparable<Vertex>
{
    public final String name;
    public Edge[] adjacencies;
    public double minDistance = Double.POSITIVE_INFINITY;
    public Vertex previous;
    public Vertex(String argName) { name = argName; }
    public String toString() { return name; }
    public int compareTo(Vertex other)
    {
        return Double.compare(minDistance, other.minDistance);
    }

}


class Edge
{
    public final Vertex target;
    public final double weight;
    public Edge(Vertex argTarget, double argWeight)
    { target = argTarget; weight = argWeight; }
}

public class Dijkstra
{
    public static void computePaths(Vertex source)
    {
        source.minDistance = 0.;
        
        // for java add () after Generic to call the correct constructor
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
        vertexQueue.add(source);

        while (!vertexQueue.isEmpty()) {
            Vertex u = vertexQueue.poll();

            // Visit each edge exiting u
            for (Edge e : u.adjacencies)
            {
                Vertex v = e.target;
                double weight = e.weight;
                double distanceThroughU = u.minDistance + weight;
                if (distanceThroughU < v.minDistance) {
                    vertexQueue.remove(v); // initially may not be in Priority Queue

                    v.minDistance = distanceThroughU ;
                    v.previous = u;
                    vertexQueue.add(v);
                }
            }
        }
    }

    public static List<Vertex> getShortestPathTo(Vertex target)
    {
        List<Vertex> path = new ArrayList<Vertex>();
        for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
            path.add(vertex);

        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args)
    {
    	
    	// straigh arrays are fixed, can only be iterated in the following ways (does have length member)
    	// You can have an array of any objects
    	// Cannot use primitive types with Generics
    	int[] ttt = {1,2,3,4,5};
    	for (int tttt:ttt) System.out.println(tttt);
    	for (int tttt=0; tttt<ttt.length; tttt++) {
    		System.out.println(ttt[tttt]);
    	}
    	
    	// create new objects (basic)
        Vertex t1 = new Vertex("A");
        Vertex t2 = new Vertex("B");
        Vertex t3 = new Vertex("C");
        Vertex t4 = new Vertex("D");
        
        // create an array of Edge objects (not expandable, iterated as below)
    	t1.adjacencies = new Edge[] {new Edge(t2, 1), new Edge(t3, 2), new Edge(t3,3)};
    	for (Edge e: t1.adjacencies) System.out.println(e);
    	for (int tttt=0; tttt<t1.adjacencies.length; tttt++)
    		System.out.println(t1.adjacencies[tttt]);
    	
    	// special case of ArrayList create from an array (Restriction cannot modify!!!!)
//    	List<Vertex> vertices1 = Arrays.asList(t1,t2,t3); // cannot add with asList
    	
    	//ArrayList instantiated from scratch and elements added
    	//dynamic and can use all of the methods of an ArrayList
    	List<Vertex> vertices2 = new ArrayList<Vertex>();
    	vertices2.add(t1);
    	vertices2.add(t2);
    	vertices2.add(t3);
    	vertices2.add(0,t4);
    	System.out.println("vertices2 size: " + vertices2.size());
    	for (Vertex v: vertices2) System.out.println(v);
    	
        // mark all the vertices 
        Vertex A = new Vertex("A");
        Vertex B = new Vertex("B");
        Vertex D = new Vertex("D");
        Vertex F = new Vertex("F");
        Vertex K = new Vertex("K");
        Vertex J = new Vertex("J");
        Vertex M = new Vertex("M");
        Vertex O = new Vertex("O");
        Vertex P = new Vertex("P");
        Vertex R = new Vertex("R");
        Vertex Z = new Vertex("Z");

        // set the edges and weight
        A.adjacencies = new Edge[]{ new Edge(M, 8) };
        B.adjacencies = new Edge[]{ new Edge(D, 11) };
        D.adjacencies = new Edge[]{ new Edge(B, 11) };
        F.adjacencies = new Edge[]{ new Edge(K, 23) };
        K.adjacencies = new Edge[]{ new Edge(O, 40) };
        J.adjacencies = new Edge[]{ new Edge(K, 25) };
        M.adjacencies = new Edge[]{ new Edge(R, 8) };
        O.adjacencies = new Edge[]{ new Edge(K, 40) };
        P.adjacencies = new Edge[]{ new Edge(Z, 18) };
        R.adjacencies = new Edge[]{ new Edge(P, 15) };
        Z.adjacencies = new Edge[]{ new Edge(P, 18) };

        computePaths(A); // run Dijkstra
        System.out.println("Distance to " + Z + ": " + Z.minDistance);
        List<Vertex> path = getShortestPathTo(Z);
        System.out.println("Path: " + path);
    }
}