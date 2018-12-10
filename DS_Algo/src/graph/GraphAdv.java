package graph;

import java.util.*;

/*
 * This class separates vertex and edges and treated them as class
 */
public class GraphAdv<T> {
	private List<Edge<T>> allEdges;
}

class Vertex<T> {
	
}

class Edge<T> {
	private boolean isDirected = false;
	private Vertex<T> vertex1;
	private Vertex<T> vertex2;
	private int weight;
	
	Edge(Vertex<T> vertex1, Vertex<T> vertex2) {
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
	}
	
	Edge(Vertex<T> vertex1, Vertex<T> vertex2, boolean isDirected, int weight) {
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
		this.isDirected = isDirected;
		this.weight = weight;
	}
	
	Edge(Vertex<T> vertex1, Vertex<T> vertex2, boolean isDirected) {
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
		this.isDirected = isDirected;
	}
	
	/*
	 * Return edge weight
	 */
	int getWeight() {
		return weight;
	}
	
	Vertex<T> getVertex1() {
		return vertex1;
	}
	
	Vertex<T> getVertex2() {
		return vertex2;
	}
	
	boolean isDirected() {
		return isDirected;
	}
}