package graph;

import java.util.*;

public class GraphDemo {
	
	Graph graph;
	
	public GraphDemo(int v) {
		graph = new Graph(v);
	}
	
	/*
	 * add edge between source and destination vertex (Directed graph)
	 */
	void addEdgeDirected(int s, int d) {
		
		graph.adjList[s].add(d);
		
	}
	
	/*
	 * add edge between source and destination vertex (Undirected graph)
	 */
	void addEdgeUndirected(int s, int d) {
		
		graph.adjList[s].add(d);
		graph.adjList[d].add(s);
		
	}
	
	/*
	 * Display graph
	 */
	void printGraph() {
		
		System.out.println("*** Graph ***");
		for (int i = 0; i < graph.vertex; i++) {
			@SuppressWarnings("rawtypes")
			Iterator iterator = graph.adjList[i].iterator();
			while (iterator.hasNext())
				System.out.print(iterator.next() + " ");
		}
		System.out.println("");
		
	}
	
}

/**
 * Graph class represented by adj list
 */

class Graph {
	
	LinkedList<Integer>[] adjList;
	int vertex;
	
	@SuppressWarnings("unchecked")
	Graph (int v) {
		vertex = v;
		adjList = new LinkedList[v];
		
		for (int i = 0; i < vertex; i++)
			adjList[i] = new LinkedList<Integer> ();
	}
}