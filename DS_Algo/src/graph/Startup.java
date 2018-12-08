package graph;

public class Startup {

	public static void main(String[] args) {
		
		/*
		 * GraphDemo class run
		 * Uncomment and execute
		 *
		GraphDemo graphDemo = new GraphDemo(4);
		graphDemo.graph.addEdgeDirected(0, 1);
		graphDemo.graph.addEdgeDirected(1, 2);
		graphDemo.graph.addEdgeDirected(0, 2);
		graphDemo.graph.addEdgeDirected(2, 0);
		graphDemo.graph.addEdgeDirected(2, 3);
		graphDemo.graph.addEdgeDirected(3, 3);

		graphDemo.graph.printGraph();
		graphDemo.bfs(0);
		graphDemo.dfs(2);
		*/
		StronglyConnectedComponent scc = new StronglyConnectedComponent(5);
		scc.graph.addEdgeDirected(0, 2);
		scc.graph.addEdgeDirected(0, 3);
		scc.graph.addEdgeDirected(1, 0);
		scc.graph.addEdgeDirected(2, 1);
		scc.graph.addEdgeDirected(3, 4);
		
		scc.mainRoutine();
		
	}

}
