package graph;

import java.util.*;

public class OrderCharacter {

	GraphAdvMod<String> graph;
	String[] words;

	OrderCharacter(String[] words) {
		graph = new GraphAdvMod<String> (true);
		this.words = words;
	}

	void compare(String s1, String s2) {
		int minSize = s1.length() > s2.length() ? s2.length() : s1.length();

		for(int i = 0; i < minSize; i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				graph.addEdge(Character.toString(s1.charAt(i)), Character.toString(s2.charAt(i)), 0);
				break;
			}
		}
	}

	void dfs(VertexMod<String> vv, Stack<String> stack, Vector<String> visited) {
		if (!visited.contains(vv.id))
			visited.add(vv.id);

		VertexMod<String> vv2 = null;

		for (EdgeMod<String> e : vv.getEdges()) {
			if (vv.id == e.getVertex1().id)
				vv2 = e.getVertex2();
			else
				vv2 = e.getVertex1();

			if (!visited.contains(vv2.id))
				dfs(vv2, stack, visited);
		}

		stack.push(vv.id);
	}


	void orderCharacter() {

		for(int i = 0; i < words.length-1; i++) {
			compare(words[i], words[i+1]);
		}

		Stack<String> stack = new Stack<String> ();
		Vector<String> visited = new Vector<String> ();

		for (VertexMod<String> vv : graph.getAllVertex()) {

			if (!visited.contains(vv.id))
				dfs(vv, stack, visited);
		}

		//print the result
		while (stack.size() > 0)
			System.out.println(stack.pop());
	}

}