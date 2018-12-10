package graph;

/*
 * Union-Find algorithm is useful detecting any cycle in the
 * undirected graph.
 * 
 * Use Array to track the parent-child vertex for each edge
 */
public class UnionFindAlgo {
	
	Graph graph;
	int[] parent;
	int v;
	
	UnionFindAlgo(int v) {
		graph = new Graph(v);
		parent = new int[v];
		
		//initialize each array element as -1 i.e parent to itself
		for (int i = 0; i < v; i++)
			parent[i] = -1;
	}
	
	/*
	 * this routine returns the parent of the set
	 * Example: 0 -> 1, then {0, 1} forms the set and 1 is the parent of element 0
	 */
	int find(int source) {
		return 0;
	}
	
	/*
	 * union operation between two sets if no cycle detected
	 */
	void union() {
		//TO-DO
	}
	
	/*
	 * Main routine to check if cycle is found or not
	 */
	boolean isCycle() {
		return false;
	}
}
