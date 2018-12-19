package graph;

public class FloydWarshallAlgo {
	GraphAdjMatrix graph;
	
	FloydWarshallAlgo(GraphAdjMatrix graph) {
		this.graph = graph;
	}
	
	void computeAllpairShortestPath() {
		int n = graph.vertex;
		int[][] finalPath = graph.adjMatrix;
		int[][] temp = graph.adjMatrix;
		
		for (int k = 0; k < n; k++) {
			finalPath = temp;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (i == j)
						temp[i][j] = 0;
					else if (temp[i][j] > (temp[i][k] + temp[k][j]))
							temp[i][j] = temp[i][k] + temp[k][j];
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(finalPath[i][j] + " ");
			}
			System.out.println("");
		}
	}
}

class GraphAdjMatrix {
	int vertex;
	int[][] adjMatrix;
	
	GraphAdjMatrix(int vertex) {
		this.vertex = vertex;
		adjMatrix = new int[vertex][vertex];

		for (int i = 0; i < vertex; i++) {
			for (int j = 0; j < vertex; j++) {
				if (i == j)
					adjMatrix[i][j] = 0;
				else
					adjMatrix[i][j] = Short.MAX_VALUE;
			}
		}
	}
	
	/*
	 * add directed edge
	 */
	void addDirectedEdge(int source, int destination, int weight) {
		adjMatrix[source][destination] = weight;
	}
}
