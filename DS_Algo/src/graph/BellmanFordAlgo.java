package graph;

public class BellmanFordAlgo {
	GraphAdv<Integer> graph;

	BellmanFordAlgo(GraphAdv<Integer> graph) {
		this.graph = graph;
	}

	boolean shortestPath(int root) {

		for (Vertex<Integer> v : graph.getAllVertex()) {
			v.setData(Integer.MAX_VALUE);

			if (v.id == root)
				v.setData(0);
		}

		for (int i = 1; i < graph.getAllVertex().size()-1; i++) {

			for (Edge<Integer> e : graph.getAllEdges()) {
				// Avoid integer cross range
				if (e.getVertex2().getData() == Integer.MAX_VALUE && e.getVertex1().getData() == Integer.MAX_VALUE
						|| e.getVertex1().getData() == Integer.MAX_VALUE)
					continue;
				
				if (e.getVertex2().getData() > e.getVertex1().getData() + e.getWeight()) {
					e.getVertex2().setData(e.getVertex1().getData() + e.getWeight()); 
				}
			}
		
		}

		//check negative weight edge cycle
		for (Edge<Integer> e : graph.getAllEdges()) {
			if (e.getVertex2().getData() > e.getVertex1().getData() + e.getWeight())
				return false;
		}

		//print the final shortest path from the source
		for (Vertex<Integer> v : graph.getAllVertex())
			System.out.println(v.id + " --> " + v.getData());

		return true;
	}
}
