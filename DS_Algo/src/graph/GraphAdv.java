package graph;

import java.util.*;

/*
 * This class separates vertex and edges and treated them as class
 */
public class GraphAdv<E> {
	LinkedList<Vertex<E>>[] adjList;
	@SuppressWarnings("rawtypes")
	LinkedList<Edge> edgeList;
	int vertex;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	GraphAdv(int v) {
		vertex = v;
		edgeList = new LinkedList<Edge> ();
		adjList = new LinkedList[v];

		for (int i = 0; i < vertex; i++) {
			adjList[i] = new LinkedList<Vertex<E>> ();
		}
	}

	@SuppressWarnings("unchecked")
	void addEdgeUndirectedWeight(int v1, int v2, int weight) {
		Vertex<Integer> v11 = new Vertex<Integer> (v1);
		Vertex<Integer> v22 = new Vertex<Integer> (v2);
		@SuppressWarnings("rawtypes")
		Edge edge = new Edge(v11, v22, weight);
		edgeList.add(edge);
		adjList[v1].add((Vertex<E>) v22);
		adjList[v2].add((Vertex<E>) v11);
	}
}

class Vertex<E> {
	private int k;
	private int val;

	Vertex (int val) {
		this.val = val;
	}
	
	void setKey(int key) {
		k = key;
	}
	
	int getKey() {
		return k;
	}
}

class Edge<E> {
	Vertex<E> v1;
	Vertex<E> v2;
	int weight;

	Edge() {
		v1 = null;
		v2 = null;
		weight = 0;
	}

	Edge(Vertex<E> v1, Vertex<E> v2, int weight) {
		this.v1 = v1;
		this.v2 = v2;
		this.weight = weight;
	}

	int getWeight() {
		return weight;
	}

	Vertex<E> getVertex1() {
		return v1;
	}

	Vertex<E> getVertex2() {
		return v2;
	}
}