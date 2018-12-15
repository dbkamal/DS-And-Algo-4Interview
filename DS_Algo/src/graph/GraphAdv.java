package graph;

import java.util.*;

/*
 * This class separates vertex and edges and treated them as class
 * Ref: https://github.com/mission-peace/interview/blob/master/src/com/interview/graph/Graph.java
 */
public class GraphAdv<E> {
	List<Edge<E>> allEdges;
	Map<Long, Vertex<E>> allVertex;
	boolean isDirected = false;

	GraphAdv(boolean isDirected) {
		this.isDirected = isDirected;
		allEdges = new ArrayList<Edge<E>> ();
		allVertex = new HashMap<Long, Vertex<E>> ();
	}

	void addEdge(long id1, long id2, int weight) {
		Vertex<E> v1 = null;
		if(allVertex.containsKey(id1)) {
			v1 = allVertex.get(id1);
		}
		else {
			v1 = new Vertex<E> (id1);
		}
		
		Vertex<E> v2 = null;
		if(allVertex.containsKey(id2)) {
			v2 = allVertex.get(id2);
		}
		else {
			v2 = new Vertex<E> (id2);
		}
		
		Edge<E> edge = new Edge<E> (v1, v2, isDirected, weight);
		allEdges.add(edge);
		v1.addAdjVertex(edge, v2);
		
		if(!isDirected)
			v2.addAdjVertex(edge, v1);
	}
	
	void setDataVertex(long id, E data) {
		if(allVertex.containsKey(id)) {
			Vertex<E> v1 = allVertex.get(id);
			v1.setData(data);
		}
	}
	
	List<Edge<E>> getAllEdges() {
		return allEdges;
	}
	
	Collection<Vertex<E>> getAllVertex() {
		return allVertex.values();
	}
}

class Vertex<E> {
	long id;
	private E data;
	private List<Edge<E>> edges = new ArrayList<> ();
	private List<Vertex<E>> adjVertex = new ArrayList<> ();

	Vertex (long id) {
		this.id = id;
	}
	
	void setData(E data) {
		this.data = data;
	}
	
	E getData() {
		return data;
	}
	
	void addAdjVertex(Edge<E> e, Vertex<E> v) {
		edges.add(e);
		adjVertex.add(v);
	}
	
	List<Edge<E>> getEdges() {
		return edges;
	}
	
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vertex other = (Vertex) obj;
        if (id != other.id)
            return false;
        return true;
    }
}

class Edge<T> {
	@SuppressWarnings("unused")
	private boolean isDirected = false;
	private Vertex<T> v1;
	private Vertex<T> v2;
	private int weight;

	Edge(Vertex<T> v1, Vertex<T> v2) {
		this.v1 = v1;
		this.v2 = v2;
	}

	Edge(Vertex<T> v1, Vertex<T> v2, boolean isDirected, int weight) {
		this.v1 = v1;
		this.v2 = v2;
		this.isDirected = isDirected;
		this.weight = weight;
	}

	int getWeight() {
		return weight;
	}

	Vertex<T> getVertex1() {
		return v1;
	}

	Vertex<T> getVertex2() {
		return v2;
	}
}