package graph;

import java.util.*;

public class PrimAlgo {
	
	GraphAdv<Integer> graph;
	
	PrimAlgo (GraphAdv<Integer> graph) {
		this.graph = graph;
	}
	
	@SuppressWarnings("unlikely-arg-type")
	void prim(int r) {
		
		int cost = 0;
		ArrayList<Integer> visited = new ArrayList<Integer> ();
		Map<Vertex<Integer>,Edge<Integer>> vertexToEdge = new HashMap<>();
		PriorityQueue<Vertex<Integer>> minQ = new PriorityQueue<Vertex<Integer>> (new MyComparator<Integer> ());
		//insert all vertices with infinite value
		for(Vertex<Integer> v : graph.getAllVertex()) {
			v.setData(Integer.MAX_VALUE);
			
			if (v.id == r)
				v.setData(0);
			
			minQ.add(v);
		}
		
		while (minQ.size() > 0) {
			Vertex<Integer> v = minQ.poll();
			
			for (Edge<Integer> e : v.getEdges()) {
				Vertex<Integer> adjacent = getVertexForEdge(v, e);
				if (!visited.contains(adjacent.id) && adjacent.getData() > e.getWeight()) {
					vertexToEdge.put(adjacent, e);
					visited.add((int) adjacent.id);
					adjacent.setData(e.getWeight());
					cost += adjacent.getData();
				}
			}
		}
		
		System.out.println(cost);
	}
	
	Vertex<Integer> getVertexForEdge (Vertex<Integer> v, Edge<Integer> e) {
		return e.getVertex1().equals(v) ? e.getVertex2() : e.getVertex1();
	}
	
}

class MyComparator<E> implements Comparator<Vertex<E>> {
	@Override
	public int compare(Vertex<E> o1, Vertex<E> o2) {
		int val1 = (Integer) o1.getData();
		int val2 = (Integer) o2.getData();
		return val1 - val2;
	}
}
