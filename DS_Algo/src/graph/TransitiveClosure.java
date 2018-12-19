package graph;

public class TransitiveClosure {
	GraphAdjMatrix2 graph;

	TransitiveClosure(GraphAdjMatrix2 graph) {
		this.graph = graph;
	}

	void transClosure() {
		int[][] finalPath = graph.adjMatrix;
		int[][] temp = graph.adjMatrix;
		int n = graph.vertex;

		for (int k = 0; k < n; k++) {
			finalPath = temp;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					temp[i][j] = (temp[i][j] != 0) || ((temp[i][k] != 0) && (temp[k][j] != 0)) ? 1 : 0;
				}
			}
		}
		
		//print the result
		for (int i = 0; i < n; i++) {
			System.out.println();
			for (int j = 0; j < n; j++) {
				System.out.print(finalPath[i][j] + " ");
			}
		}
	}
}

class GraphAdjMatrix2 {
	int vertex;
	int[][] adjMatrix;

	GraphAdjMatrix2(int vertex) {
		this.vertex = vertex;
		adjMatrix = new int[vertex][vertex];

		for (int i = 0; i < vertex; i++) {
			for (int j = 0; j < vertex; j++) {
				if (i == j)
					adjMatrix[i][j] = 1;
				else
					adjMatrix[i][j] = 0;
			}
		}
	}

	void addDirectedEdge(int source, int dest, int weight) {
		adjMatrix[source][dest] = 1;
	}
}
