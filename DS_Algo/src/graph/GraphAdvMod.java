package graph;

import java.util.*;

/*
 * This class separates vertex and edges and treated them as class
 * Ref: https://github.com/mission-peace/interview/blob/master/src/com/interview/graph/Graph.java
 */
public class GraphAdvMod<E> {
	List<EdgeMod<E>> allEdges;
	Map<E, VertexMod<E>> allVertex;
	boolean isDirected = false;

	GraphAdvMod(boolean isDirected) {
		this.isDirected = isDirected;
		allEdges = new ArrayList<EdgeMod<E>> ();
		allVertex = new HashMap<E, VertexMod<E>> ();
	}

	void addEdge(E id1, E id2, int weight) {
		VertexMod<E> v1 = null;
		if(allVertex.containsKey(id1)) {
			v1 = allVertex.get(id1);
		}
		else {
			v1 = new VertexMod<E> (id1);
			allVertex.put(id1, v1);
		}
		
		VertexMod<E> v2 = null;
		if(allVertex.containsKey(id2)) {
			v2 = allVertex.get(id2);
		}
		else {
			v2 = new VertexMod<E> (id2);
			allVertex.put(id2, v2);
		}
		
		EdgeMod<E> edge = new EdgeMod<E> (v1, v2, isDirected, weight);
		allEdges.add(edge);
		v1.addAdjVertex(edge, v2);
		
		if(!isDirected)
			v2.addAdjVertex(edge, v1);
	}
	
	void setDataVertex(E id, E data) {
		if(allVertex.containsKey(id)) {
			VertexMod<E> v1 = allVertex.get(id);
			v1.setData(data);
		}
	}
	
	List<EdgeMod<E>> getAllEdges() {
		return allEdges;
	}
	
	Collection<VertexMod<E>> getAllVertex() {
		return allVertex.values();
	}
	
	/*
	 * Remove Vertex and Edge procedure
	 */
	void removeVertexAndEdges(VertexMod<E> vertex) {
		if(allVertex.containsKey(vertex.id)) {
			List<EdgeMod<E>> removeEdge = vertex.getEdges();
			vertex.getEdges().clear();
			allEdges.removeAll(removeEdge);
		}
		
		//Remove vertex
		if(allVertex.containsKey(vertex.id)) {
			allVertex.remove(vertex.id);
		}
	}
}

class VertexMod<E> {
	E id;
	private E data;
	private List<EdgeMod<E>> edges = new ArrayList<> ();
	private List<VertexMod<E>> adjVertex = new ArrayList<> ();

	VertexMod (E id) {
		this.id = id;
	}
	
	void setData(E data) {
		this.data = data;
	}
	
	E getData() {
		return data;
	}
	
	void addAdjVertex(EdgeMod<E> e, VertexMod<E> v) {
		edges.add(e);
		adjVertex.add(v);
	}
	
	List<EdgeMod<E>> getEdges() {
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
        @SuppressWarnings("rawtypes")
		VertexMod other = (VertexMod) obj;
        if (id != other.id)
            return false;
        return true;
    }
}

class EdgeMod<T> {
	@SuppressWarnings("unused")
	private boolean isDirected = false;
	private VertexMod<T> v1;
	private VertexMod<T> v2;
	private int weight;

	EdgeMod(VertexMod<T> v1, VertexMod<T> v2) {
		this.v1 = v1;
		this.v2 = v2;
	}

	EdgeMod(VertexMod<T> v1, VertexMod<T> v2, boolean isDirected, int weight) {
		this.v1 = v1;
		this.v2 = v2;
		this.isDirected = isDirected;
		this.weight = weight;
	}

	int getWeight() {
		return weight;
	}
	
	void setWeight(int w) {
		this.weight = w;
	}

	VertexMod<T> getVertex1() {
		return v1;
	}

	VertexMod<T> getVertex2() {
		return v2;
	}
	
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        @SuppressWarnings("unchecked")
        EdgeMod<T> other = (EdgeMod<T>) obj;
        if (v1 == null) {
            if (other.v1 != null)
                return false;
        } else if (!v1.equals(other.v1))
            return false;
        if (v2 == null) {
            if (other.v2 != null)
                return false;
        } else if (!v2.equals(other.v2))
            return false;
        return true;
    }
}