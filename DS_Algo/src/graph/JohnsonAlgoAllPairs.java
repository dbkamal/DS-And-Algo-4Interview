package graph;

public class JohnsonAlgoAllPairs {

	GraphAdv<Integer> graph;
	BellmanFordAlgo bellmanFordAlgo;
	DijkstraAlgo dijkstraAlgo;
	int[] weightVertex;

	JohnsonAlgoAllPairs (GraphAdv<Integer> graph) {
		this.graph = graph;
		weightVertex = new int[graph.getAllVertex().size()];
	}

	void calculateShortestPath(int id) {
		int[] temp = new int[graph.getAllVertex().size()];
		int i = 0;
		//create a new vertex and add it's edges
		for (Vertex<Integer> vv : graph.getAllVertex()) {
			temp[i] = (int) vv.id;
			i++;
		}
		
		for (int j = 0; j < temp.length; j++) {
			graph.addEdge(id, temp[j], 0);
		}

		//run bellman-ford algorithm
		bellmanFordAlgo = new BellmanFordAlgo(graph);
		boolean flag = bellmanFordAlgo.shortestPath(id);

		if (!flag) {
			System.out.println("negative weight edge cycle");
		}
		else {
			i = 0;

			//remove newly added Vertex and it's edges
			Vertex<Integer> v = graph.allVertex.get((long) id);
			graph.removeVertexAndEdges(v);
	
			//collect all vertex weight
			for (Vertex<Integer> vv1: graph.getAllVertex()) {
				weightVertex[i] = vv1.getData();
				i++;
			}
			
			//re-weight all edges
			for (Edge<Integer> e : graph.allEdges) {
				if (e.getVertex1().id == id)
					continue;
				
				int newWeight = e.getWeight() + e.getVertex1().getData() - e.getVertex2().getData();
				e.setWeight(newWeight);
			}

			//run dijkstra algo to compute all pair shortest path
			dijkstraAlgo = new DijkstraAlgo(graph);

			for (Vertex<Integer> vv2 : graph.getAllVertex()) {
				System.out.println("** Shortest Path for vertex : " + vv2.id + " ***");
				dijkstraAlgo.calculateShortestPath((int) vv2.id);
			}
		}

	}

}