package graph;

import java.util.*;

public class PrimAlgo {
	
	GraphAdv<Integer> graph;
	
	PrimAlgo (GraphAdv<Integer> graph) {
		this.graph = graph;
	}
	
	/*
	 * Main routine.
	 * Arg: pass the starting root of the graph
	 */
	void prim(int r) {
		
		Map<Vertex<Integer>,Edge<Integer>> vertexToEdge = new HashMap<>();
		PriorityQueue<Vertex<Integer>> minQ = new PriorityQueue<Vertex<Integer>> (new MyComparator<Integer> ());
		ArrayList<Edge<Integer>> result = new ArrayList<Edge<Integer>> ();
		
		//insert all vertices and set data infinite
		for(Vertex<Integer> v : graph.getAllVertex()) {
			v.setData(Integer.MAX_VALUE);
			
			if (v.id == r)
				v.setData(0);
			
			minQ.add(v);
		}
		
		while (minQ.size() > 0) {
			System.out.println("** minQ now **");
			for (Vertex<Integer> vv : minQ) {
				System.out.println(vv.id + " " + vv.getData());
			}
			
			Vertex<Integer> v = minQ.poll();
			
			if (vertexToEdge.containsKey(v)) {
				result.add(vertexToEdge.get(v));
			}
			
			for (Edge<Integer> e : v.getEdges()) {
				Vertex<Integer> adjacent = getVertexForEdge(v, e);
				
				if (minQ.contains(adjacent) && adjacent.getData() > e.getWeight()) {
					vertexToEdge.put(adjacent, e);
					minQ.remove(adjacent);
					adjacent.setData(e.getWeight());
					minQ.add(adjacent);
				}
			}
		}
		
		for (Edge<Integer> e : result) {
			System.out.println(e.getVertex1().id + " - " + e.getVertex2().id);
		}
		
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
		
		if (val1 < val2)
			return -1;
		
		if (val1 > val2)
			return 1;
		
		return 0;
	}
}
