package graph;

import java.util.*;

/*
 * This class decompose the directed graph into
 * Strongly Connected Component using Kosaraju's algorithm
 */
public class StronglyConnectedComponent {

	Graph graph;
	
	StronglyConnectedComponent (int v) {
		graph = new Graph(v);
	}
	
	void dfsUtil(int s, ArrayList<Integer> visited, Stack<Integer> stack, boolean useStack) {
		
		if (!visited.contains(s)) {
			visited.add(s);
			Iterator<Integer> it = graph.adjList[s].iterator();
			
			//print the SCC
			if (!useStack) {
				System.out.print(s + " ");
				System.out.println();
			}
			
			while (it.hasNext()) {
				int p = it.next();
				if (!visited.contains(p))
					dfsUtil(p, visited, stack, useStack); 
			}
		}
		
		if (useStack)
			stack.push(s);
		
	}
	
	void dfs(int s, ArrayList<Integer> visited, Stack<Integer> stack, boolean useStack) {
		if (!visited.contains(s))
			dfsUtil(s, visited, stack, useStack);
	}
	
	//Reverse the graph i.e. u -> v will change to point u <- v
	void reverseGraph() {
		@SuppressWarnings("unchecked")
		LinkedList<Integer>[] tempList = new LinkedList[graph.vertex];
		
		for (int i = 0; i < graph.vertex; i++)
			tempList[i] = new LinkedList<Integer> ();
		
		for (int i = 0; i < graph.vertex; i++) {
			int s = i;
			Iterator<Integer> it = graph.adjList[s].iterator();
			
			while (it.hasNext()) {
				int p = it.next();
				tempList[p].add(s);
			}
		}
		
		graph.adjList = tempList;
	}
	
	void mainRoutine() {
		ArrayList<Integer> visited = new ArrayList<Integer> ();
		Stack<Integer> stack = new Stack<Integer> ();
		boolean useStack = true; // useful either push to stack or print the SCC
		
		/*
		 * check all the vertices and if its not visited before,
		 * do the dfs and push the last element based on finish time 
		 */
		for (int i = 0; i < graph.vertex; i++) {
			dfs(i, visited, stack, useStack);
		}
		
		// Reverse the graph edge and empty the visited set to reuse
		reverseGraph();
		visited.clear();
		
		// pop each stack element and call dfs again
		while (stack.size() > 0) {
			int s = stack.pop();
			System.out.println("*** scc list ***");
			dfs(s, visited, stack, !useStack);
		}
	}
	
}
