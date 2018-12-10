package graph;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/*
 * Main Graph class. Each Graph has its own adjustment list and vertex (int) number
 * Add weight for undirected graph
 */

public class Graph {
	LinkedList<Integer>[] adjList;
	HashMap<String, Integer> edgeList;
	int vertex;
	
	@SuppressWarnings("unchecked")
	Graph (int v) {
		vertex = v;
		adjList = new LinkedList[v];
		edgeList = new HashMap<String, Integer>();
		
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
	 * add edge between source and destination vertex (Undirected graph)
	 * add weight to each edge
	 */
	void addEdgeUndirectedWeight(int s, int d, int weight) {
		adjList[s].add(d);
		adjList[d].add(s);
		
		//Add weight between two edges
		String key = String.valueOf(s) + ", " + String.valueOf(d);
		edgeList.put(key, weight);
	}
	
	/*
	 * Return the edge weight
	 */
	int getWeight(int s, int d) {
		String key1 = String.valueOf(s) + ", " + String.valueOf(d);
		String key2 = String.valueOf(d) + ", " + String.valueOf(s);
		
		if (edgeList.containsKey(key1)) {
			return edgeList.get(key1);
		}
		
		if (edgeList.containsKey(key2)) {
			return edgeList.get(key2);
		}
		
		return 0;
	}
	
	/*
	 * Return all edge weight
	 */
	Collection<Integer> allWeight() {
		return edgeList.values();
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
