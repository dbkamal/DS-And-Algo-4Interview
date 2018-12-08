package graph;

import java.util.Iterator;
import java.util.LinkedList;

/*
 * Main Graph class. Each Graph has its own adjustment list and vertex (int) number
 */

public class Graph {
	LinkedList<Integer>[] adjList;
	int vertex;
	
	@SuppressWarnings("unchecked")
	Graph (int v) {
		vertex = v;
		adjList = new LinkedList[v];
		
		for (int i = 0; i < vertex; i++)
			adjList[i] = new LinkedList<Integer> ();
	}
	
	/*
	 * add edge between source and destination vertex (Directed graph)
	 */
	void addEdgeDirected(int s, int d) {
		adjList[s].add(d);
	}
	
	/*
	 * add edge between source and destination vertex (Undirected graph)
	 */
	void addEdgeUndirected(int s, int d) {
		adjList[s].add(d);
		adjList[d].add(s);
	}
	
	/*
	 * Display graph
	 */
	void printGraph() {
		
		System.out.println("*** Graph ***");
		for (int i = 0; i < vertex; i++) {
			System.out.print("Vertex " + i + " -> ");
			@SuppressWarnings("rawtypes")
			Iterator iterator = adjList[i].iterator();
			while (iterator.hasNext())
				System.out.print(iterator.next() + " ");
			
			System.out.println("");
		}
		System.out.println("** Display Graph Done ***");
		
	}
}
