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
    	
    	// create new vertices and links
        Vertex A = new Vertex("A");
        Vertex B = new Vertex("B");
        Vertex C = new Vertex("C");
        Vertex D = new Vertex("D");
        
        A.adjacencies = new Edge[]{ new Edge(B, 2), new Edge(C, 3) };
        B.adjacencies = new Edge[]{ new Edge(D, 3) };
        C.adjacencies = new Edge[]{ new Edge(D, 1) };
        D.adjacencies = new Edge[]{ new Edge(A, 1) };

        computePaths(A); // run Dijkstra
        System.out.println("Distance to " + D + ": " + D.minDistance);
        List<Vertex> path = getShortestPathTo(D);
        System.out.println("Path: " + path);
    }
}