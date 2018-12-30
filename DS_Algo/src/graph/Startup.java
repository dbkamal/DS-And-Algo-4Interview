package graph;

public class Startup {

	public static void main(String[] args) {
		
		int[][] matrix = {{ 3 , 3 , 1 , 0 },
                			  { 3 , 0 , 3 , 3 },
                			  { 2 , 3 , 0 , 3 },
                			  { 0 , 3 , 3 , 3 }};
		MinMoveMatrix obj = new MinMoveMatrix(matrix);
		System.out.println(obj.minMove());
		
		/*
		ShorestPathPrime obj = new ShorestPathPrime();
		System.out.println(obj.shorestPath(1373, 8017));
		*/
		
		/*
		GraphAdv<Integer> g = new GraphAdv<Integer> (true);
		g.addEdge(0, 1, 0);
		g.addEdge(0, 4, 0);
		g.addEdge(0, 2, 0);
		g.addEdge(1, 4, 0);
		g.addEdge(1, 3, 0);
		g.addEdge(2, 4, 0);
		g.addEdge(3, 2, 0);
		
		CountPathTwoVertex obj = new CountPathTwoVertex(g);
		int count = obj.countPathTwoVertex(0, 4);
		System.out.print(count);
		*/
		
		/*
		GraphAdv<Integer> g = new GraphAdv<Integer> (true);
		g.addEdge(0, 1, -5);
		g.addEdge(0, 2, 2);
		g.addEdge(0, 3, 3);
		g.addEdge(1, 2, 4);
		g.addEdge(2, 3, 1);
		
		JohnsonAlgoAllPairs obj = new JohnsonAlgoAllPairs(g);
		obj.calculateShortestPath(4);
		*/
		
		/*
		GraphAdjMatrix2 g = new GraphAdjMatrix2(4);
		int weight = 0;
		g.addDirectedEdge(1, 2, weight);
		g.addDirectedEdge(1, 3, weight);
		g.addDirectedEdge(2, 1, weight);
		g.addDirectedEdge(3, 2, weight);
		g.addDirectedEdge(3, 0, weight);
		
		TransitiveClosure obj = new TransitiveClosure(g);
		obj.transClosure();
		*/
		
		/*
		GraphAdjMatrix g = new GraphAdjMatrix(4);
		g.addDirectedEdge(0, 1, 3);
		g.addDirectedEdge(0, 3, 7);
		g.addDirectedEdge(1, 0, 8);
		g.addDirectedEdge(1, 2, 2);
		g.addDirectedEdge(2, 0, 5);
		g.addDirectedEdge(2, 3, 1);
		g.addDirectedEdge(3, 0, 2);
		
		FloydWarshallAlgo obj = new FloydWarshallAlgo(g);
		obj.computeAllpairShortestPath();
		*/
		/*
		GraphAdv<Integer> g = new GraphAdv<Integer> (true);
		g.addEdge(0, 1, 10);
		g.addEdge(0, 3, 5);
		g.addEdge(1, 2, 1);
		g.addEdge(1, 3, 2);
		g.addEdge(2, 4, 4);
		g.addEdge(3, 1, 3);
		g.addEdge(3, 2, 9);
		g.addEdge(3, 4, 2);
		g.addEdge(4, 0, 7);
		g.addEdge(4, 2, 6);
		
		DijkstraAlgo obj = new DijkstraAlgo(g);
		obj.calculateShortestPath(0);
		*/
		
		/*
		GraphAdv<Integer> g = new GraphAdv<Integer> (true);
		g.addEdge(1, 2, 4);
		g.addEdge(1, 4, 5);
		g.addEdge(2, 4, 5);
		g.addEdge(3, 2, -10);
		g.addEdge(4, 3, 3);
		*/
		/*
		 * test case with no negative weight edge cycle
		g.addEdge(1, 2, 6);
		g.addEdge(1, 4, 5);
		g.addEdge(1, 3, 5);
		g.addEdge(2, 5, -1);
		g.addEdge(3, 2, -2);
		g.addEdge(3, 5, 1);
		g.addEdge(4, 3, -2);
		g.addEdge(4, 6, -1);
		g.addEdge(5, 7, 3);
		g.addEdge(6, 7, 3);
		*/
		/*
		BellmanFordAlgo obj = new BellmanFordAlgo(g);
		System.out.println(obj.shortestPath(1));
		*/
		
		/*
		g.addEdge(0, 1, 4);
		g.addEdge(1, 2, 8);
		g.addEdge(2, 3, 7);
		g.addEdge(0, 7, 8);
		g.addEdge(1, 7, 11);
		g.addEdge(7, 6, 1);
		g.addEdge(6, 5, 2);
		g.addEdge(3, 5, 14);
		g.addEdge(2, 8, 2);
		g.addEdge(8, 6, 6);
		g.addEdge(7, 8, 7);
		g.addEdge(2, 5, 4);
		g.addEdge(3, 4, 9);
		g.addEdge(4, 5, 10);
		
		PrimAlgo obj = new PrimAlgo(g);
		obj.prim(0);
		*/
		
		
		/*
		UnionFindAlgo g = new UnionFindAlgo(9);
		g.graph.addEdgeUndirectedWeight(0, 1, 4);
		g.graph.addEdgeUndirectedWeight(1, 2, 8);
		g.graph.addEdgeUndirectedWeight(2, 3, 7);
		g.graph.addEdgeUndirectedWeight(0, 7, 8);
		g.graph.addEdgeUndirectedWeight(1, 7, 11);
		g.graph.addEdgeUndirectedWeight(7, 6, 1);
		g.graph.addEdgeUndirectedWeight(6, 5, 2);
		g.graph.addEdgeUndirectedWeight(3, 5, 14);
		g.graph.addEdgeUndirectedWeight(2, 8, 2);
		g.graph.addEdgeUndirectedWeight(8, 6, 6);
		g.graph.addEdgeUndirectedWeight(7, 8, 7);
		g.graph.addEdgeUndirectedWeight(2, 5, 4);
		g.graph.addEdgeUndirectedWeight(0, 1, 4);
		g.graph.addEdgeUndirectedWeight(3, 4, 9);
		g.graph.addEdgeUndirectedWeight(4, 5, 10);

		KruskalMST mst = new KruskalMST(g);
		mst.mstForest();
		*/
		
		
		/*
		UnionFindAlgo g = new UnionFindAlgo(4);
		g.graph.addEdgeUndirectedWeight(0, 1, 0);
		g.graph.addEdgeUndirectedWeight(1, 2, 0);
//		g.graph.addEdgeUndirectedWeight(2, 0, 0);
		g.graph.addEdgeUndirectedWeight(2, 3, 0);
		g.graph.addEdgeUndirectedWeight(0, 3, 0);
//		g.graph.addEdgeUndirectedWeight(3, 4, 0);
//		g.graph.addEdgeUndirectedWeight(2, 4, 0);
		
		if (g.isCycle())
			System.out.println("cycle detected");
		else
			System.out.println("no cycle detected");
		
		System.out.println("Set excluding cycle: " + java.util.Arrays.toString(g.parent));
		*/
		
		/*
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
		
		/*
		StronglyConnectedComponent scc = new StronglyConnectedComponent(5);
		scc.graph.addEdgeDirected(0, 2);
		scc.graph.addEdgeDirected(0, 3);
		scc.graph.addEdgeDirected(1, 0);
		scc.graph.addEdgeDirected(2, 1);
		scc.graph.addEdgeDirected(3, 4);
		
		scc.mainRoutine();
		*/
		
		/*
		TopologicalSort g = new TopologicalSort(6);
		g.graph.addEdgeDirected(5, 0);
		g.graph.addEdgeDirected(5, 2);
		g.graph.addEdgeDirected(2, 3);
		g.graph.addEdgeDirected(3, 1);
		g.graph.addEdgeDirected(4, 0);
		g.graph.addEdgeDirected(4, 1);
		g.sort(5);
		*/
		
	}

}
