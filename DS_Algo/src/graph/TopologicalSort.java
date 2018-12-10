package graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class TopologicalSort {

	Graph graph;
	
	TopologicalSort (int v) {
		graph = new Graph(v);
	}
	
	void dfsUtil(int s, ArrayList<Integer> visited, Stack<Integer> stack) {
		if (!visited.contains(s)) {
			visited.add(s);
			
			Iterator<Integer> it = graph.adjList[s].iterator();
			while(it.hasNext()) {
				int p = it.next();
				if (!visited.contains(p))
					dfsUtil(p, visited, stack);
			}
		}
		
		stack.push(s);
	}
	
	void dfs(int s, ArrayList<Integer> visited, Stack<Integer> stack) {
		if (!visited.contains(s))
			dfsUtil(s, visited, stack);
	}
	
	void sort(int source) {
		ArrayList<Integer> visited = new ArrayList<Integer> ();
		Stack<Integer> stack = new Stack<Integer> ();
		
		dfs(source, visited, stack);
		
		//if any disconnected vertex
		for (int i = 0; i < graph.vertex; i++) {
			if (i != source) {
				dfs(i, visited, stack);
			}
		}
		
		while (stack.size() > 0) {
			System.out.print(stack.pop() + " ");
		}
	}
	
}
