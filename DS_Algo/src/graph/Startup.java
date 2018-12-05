package graph;

public class Startup {

	public static void main(String[] args) {
		
		GraphDemo graphDemo = new GraphDemo(4);
		graphDemo.addEdgeDirected(0, 1);
		graphDemo.addEdgeDirected(1, 2);
		graphDemo.addEdgeDirected(0, 2);
		graphDemo.addEdgeDirected(2, 0);
		graphDemo.addEdgeDirected(2, 3);
		graphDemo.addEdgeDirected(3, 3);

		graphDemo.printGraph();
//		graphDemo.bfs(0);
		graphDemo.dfs(2);
		
	}

}
