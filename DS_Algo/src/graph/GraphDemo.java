package graph;

import java.util.*;

public class GraphDemo {
	
	Graph graph;
	
	public GraphDemo(int v) {
		graph = new Graph(v);
	}
	
	/*
	 * Utility method to perform the dfs recursively
	 */
	void dfsUtil(int source, Vector<Integer> visited) {
		visited.add(source);
		System.out.print(source + " ");
		
		Iterator<Integer> it = graph.adjList[source].iterator();
		
		while (it.hasNext()) {
			int p = it.next();
			
			if (!visited.contains(p))
				dfsUtil(p, visited);
		}
	}
	
	/*
	 * Depth first traversal
	 */
	void dfs(int source) {
		
		Vector<Integer> visited = new Vector<Integer> ();
		System.out.println("*** dfs traversal ***");
		dfsUtil(source, visited);
	
	}
	
	/*
	 * Depth first traversal for disconnected graph
	 */
	void dfsDisconnected() {
		
		Vector<Integer> visited = new Vector<Integer> ();
		System.out.println("*** dfs traversal ***");

		//Check all the vertex
		for (int i = 0; i < graph.vertex; i++) {
			if (!visited.contains(i))
				dfsUtil(i, visited);
		}

	}
	
	/*
	 * Breadth first traversal using Queue
	 */
	void bfs(int source) {
		LinkedList<Integer> queue = new LinkedList<Integer> ();
		Vector<Integer> visited = new Vector<Integer> ();
		
		queue.add(source);
		visited.add(source);
		
		System.out.println("*** bfs traversal ***");
		
		// until queue is empty
		while (queue.size() > 0) {
			int vertex = queue.poll();
			System.out.print(vertex + " ");
			
			Iterator<Integer> it = graph.adjList[vertex].iterator();
			
			while (it.hasNext()) {
				int p = it.next();
				
				if (!visited.contains(p)) {
					queue.add(p);
					visited.add(p);
				}
			}
		}
	}
		
}