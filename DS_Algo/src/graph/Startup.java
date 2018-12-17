package graph;

public class Startup {

	public static void main(String[] args) {
		
		GraphAdv<Integer> g = new GraphAdv<Integer> (false);
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
