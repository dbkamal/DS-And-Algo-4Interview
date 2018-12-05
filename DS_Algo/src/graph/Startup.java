package graph;

public class Startup {

	public static void main(String[] args) {
		
		GraphDemo graphDemo = new GraphDemo(5);
		graphDemo.addEdgeDirected(0, 1);
		graphDemo.addEdgeDirected(1, 4);
		graphDemo.addEdgeDirected(1, 3);
		graphDemo.addEdgeDirected(2, 1);
		graphDemo.addEdgeDirected(3, 2);
		graphDemo.addEdgeDirected(4, 0);
		graphDemo.addEdgeDirected(4, 3);

		graphDemo.printGraph();
		
	}

}
