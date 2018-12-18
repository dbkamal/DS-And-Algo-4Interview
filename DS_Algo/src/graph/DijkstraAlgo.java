package graph;

import java.util.*;

public class DijkstraAlgo {

	GraphAdv<Integer> graph;

	DijkstraAlgo(GraphAdv<Integer> graph) {
		this.graph = graph;
	}

	void calculateShortestPath(int root) {

		PriorityQueue<Vertex<Integer>> minQ = new PriorityQueue<Vertex<Integer>> (new MyComparator<Integer> ());
		for (Vertex<Integer> v : graph.getAllVertex()) {
			v.setData(Integer.MAX_VALUE);
			if (v.id == root)
				v.setData(0);

			minQ.add(v);
		}

		while (minQ.size() > 0) {
			Vertex<Integer> v = minQ.poll();
			for (Edge<Integer> e : v.getEdges()) {
				Vertex<Integer> adjacentVertex = findAdjacentVertex(v, e);
				if (adjacentVertex.getData() > v.getData() + e.getWeight()) {
					minQ.remove(adjacentVertex);
					adjacentVertex.setData(v.getData() + e.getWeight());
					minQ.add(adjacentVertex);
				}
			}
		}
		
		//Print shortest path
		for (Vertex<Integer> v : graph.getAllVertex())
			System.out.println(v.id + " -> " + v.getData());

	}

	Vertex<Integer> findAdjacentVertex(Vertex<Integer> v, Edge<Integer> e) {
		return e.getVertex1().equals(v) ? e.getVertex2() : e.getVertex1();
	}
}
