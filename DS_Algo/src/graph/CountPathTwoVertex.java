package graph;

public class CountPathTwoVertex {

	GraphAdv<Integer> graph;
	int count = 0;

	CountPathTwoVertex (GraphAdv<Integer> graph) {
		this.graph = graph;
	}

	void countUtil(Vertex<Integer> v, Vertex<Integer> d) {

		Vertex<Integer> vv = null;

		for (Edge<Integer> e : v.getEdges()) {
			if (e.getVertex1().id == v.id)
				vv = e.getVertex2();
			else
				vv = e.getVertex1();

			countUtil(vv, d);
		}

		if (v.id == d.id) {
			count++;
		}
	}

	int countPathTwoVertex(int source, int destination) {

		Vertex<Integer> s = graph.allVertex.get((long) source);
		Vertex<Integer> d = graph.allVertex.get((long) destination);

		if (s == null || d == null) {
			System.out.println("No source/destination vertex found");
			return -1;
		}
		
		countUtil(s, d);

		return count;

	}

}