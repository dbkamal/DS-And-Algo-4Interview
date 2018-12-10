package graph;

import java.util.Iterator;

/*
 * Union-Find algorithm is useful detecting any cycle in the
 * undirected graph.
 * 
 * Use Array to track the parent-child vertex for each edge
 */
public class UnionFindAlgo {
	
	Graph graph;
	int[] parent;
	
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
		
		if (parent[source] < 0)
			return source;
		else {
			int val = parent[source];
			while (val >= 0) {
				source = val;
				val = parent[val];
			}
			return source;
		}
	}
	
	/*
	 * union operation between two sets if no cycle detected
	 */
	void union(int s, int d) {
		int sParent = find(s);
		int dParent = find(d);
		
		System.out.println(java.util.Arrays.toString(parent));
		System.out.println(sParent + "," + dParent);
		
		if (parent[sParent] <= parent[dParent]) {
			parent[sParent] += -1;
			parent[dParent] = s;
		}
		else {
			parent[dParent] += -1;
			parent[sParent] = d;
		}
	}
	
	/*
	 * Main routine to check if cycle is found or not
	 */
	boolean isCycle() {
		
		Iterator<String> it = graph.allKeys().iterator();
		
		while (it.hasNext()) {
			String p = it.next();
			System.out.println("key " + p);
			int comma = p.indexOf(",");
			int source = Integer.parseInt(p.substring(0, comma));
			int dest = Integer.parseInt(p.substring(comma+1, p.length()));
			
			if (find(source) == find(dest))
				return true;
			
			union(source, dest);
		}
		
		return false;
	}
}
