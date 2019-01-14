package google_coding;

import java.util.*;

//ref: https://www.careercup.com/question?id=5713002834165760

public class Connected {

	static boolean dfs (Queue<Integer> queue, Graph graph, int s, int d) {
		for (Integer i : graph.adjList[s]) {
			if (!queue.contains(i)) {
				if (i == d)
					return true;
				
				queue.add(i);
				return dfs (queue, graph, i, d);
			}
		}
		return false;
	}

	static boolean isConnected (Graph graph, int s, int d) {
		Queue<Integer> queue = new LinkedList<Integer> ();
		queue.add(s);

		for (Integer i : graph.adjList[s]) {
			if (!queue.contains(i)) {
				return dfs (queue, graph, i, d);
			}
		}

		return true;
	}

	public static void main (String[] args) {
		Graph graph = new Graph(5);
		graph.addEdgeDirected(0,1);
		graph.addEdgeDirected(0,4);
		graph.addEdgeDirected(1,3);
		graph.addEdgeDirected(1,2);
		graph.addEdgeDirected(1,4);
		graph.addEdgeDirected(2,0);
		graph.addEdgeDirected(2,4);
		graph.addEdgeDirected(3,4);

		System.out.println(isConnected(graph, 0, 4));
	}
}

class Graph {
	int vertex;
	LinkedList<Integer>[] adjList;

	@SuppressWarnings("unchecked")
	Graph (int vertex) {
		this.vertex = vertex;
		adjList = new LinkedList[vertex];

		for (int i = 0; i < vertex; i++)
			adjList[i] = new LinkedList<Integer> ();
	}

	void addEdgeDirected (int s, int d) {
		adjList[s].add(d);
	}
}