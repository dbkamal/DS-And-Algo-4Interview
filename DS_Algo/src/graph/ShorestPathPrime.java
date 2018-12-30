package graph;

import java.util.*;

public class ShorestPathPrime {

	GraphAdv<Integer> graph;
	Vector<Integer> setPrimes;
	int count = 0;

	ShorestPathPrime () {
		setPrimes = new Vector<Integer> ();
	}

	/*
	* return true if single digit changes give 4 digit prime number
	* Time complexity - O(1)
	*/
	boolean comparePrime(int n1, int n2) {
		
		if (n1 == n2)
			return false;

		String s1 = Integer.toString(n1);
		String s2 = Integer.toString(n2);
		int c = 0;

		if (s1.charAt(0) != s2.charAt(0))
			c++;

		if (s1.charAt(1) != s2.charAt(1))
			c++;

		if (s1.charAt(2) != s2.charAt(2))
			c++;

		if (s1.charAt(3) != s2.charAt(3))
			c++;

		return (c == 1);

	}

	// store all the 4 digit primes
	// Time complexity - O(n*log(log(n)))
	void listPrimes(int n) {

		boolean[] prime = new boolean[n+1];
		
		for (int i = 0; i < prime.length; i++)
			prime[i] = false;
		
		prime[0] = true;
		prime[1] = true;
		
		for (int i = 0; i < Math.sqrt(n)+1; i++) {
			if (!prime[i]) {
				//mark true all element which is multiplier of i
				for (int j = i; j < n/i+1; j++) {
					prime[j*i] = true;
				}
			}
		}
		
		for (int i = 0; i < prime.length; i++) {
			if (!prime[i] && i > 999)
				setPrimes.add(i);
		}
	}

	// Time complexity of BFS O(V+E)
	void bfsUtil(Vertex<Integer> s, Vertex<Integer> d) {
		
		LinkedList<Integer> queue = new LinkedList<Integer> ();
		int[] visited = new int[9999];
		
		for (int i = 0; i < visited.length; i++)
			visited[i] = 0;
		
		Vertex<Integer> vv = null;
		
		queue.add((int) s.id);
		visited[(int) s.id] = 1;
		
		// until queue is empty
		while (queue.size() > 0) {
			int vertex = queue.poll();
			Vertex<Integer> vv2 = graph.allVertex.get((long) vertex);
			
			for (Edge<Integer> e : vv2.getEdges()) {
				if (vv2.id == e.getVertex1().id)
					vv = e.getVertex2();
				else if (vv2.id == e.getVertex2().id)
					vv = e.getVertex1();
				
				if(visited[(int) vv.id] == 0) {
					queue.add((int) vv.id);
					visited[(int) vv.id] = visited[(int) vv2.id] + 1;
				}
				
				if (vv.id == d.id) {
					count = visited[(int) vv.id] - 1;
				}
			}
		}
	}

	void bfs(int s, int d) {

		Vertex<Integer> v1 = graph.allVertex.get((long) s);
		Vertex<Integer> v2 = graph.allVertex.get((long) d);
		
		if(v1 == null || v2 == null)
			System.out.println("vertex null");
		else
			bfsUtil(v1, v2);
	}

	//main routine
	int shorestPath(int num1, int num2) {

		graph = new GraphAdv<Integer>(false);

		if (num1 == num2)
			return 0;

		listPrimes(9999); // for 4 digit prime number

		for (int i = 0; i < setPrimes.size(); i++) {
			for (int j = i+1; j < setPrimes.size(); j++) {
				if (comparePrime(setPrimes.get(i), setPrimes.get(j))) {
					graph.addEdge(setPrimes.get(i), setPrimes.get(j), 0); // weight 0
				}
			}
		}

		bfs(num1, num2);
		return count;
	}
}