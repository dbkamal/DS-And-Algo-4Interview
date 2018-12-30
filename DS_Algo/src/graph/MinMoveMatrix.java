package graph;

import java.util.*;

public class MinMoveMatrix {

	int[][] matrix;
	GraphAdv<Integer> graph;

	MinMoveMatrix(int[][] matrix) {
		this.matrix = matrix;
	}

	int bfs(int s, int d) {
		int count = 0;

		LinkedList<Integer> queue = new LinkedList<Integer> ();
		int[] visited = new int[101];

		for (int i = 0; i < visited.length; i++)
			visited[i] = 0;

		queue.add(s);
		visited[s] = 1;
		Vertex<Integer> vv2 = null;

		while (queue.size() > 0) {
			int v = queue.poll();
			Vertex<Integer> vv = graph.allVertex.get((long) v);

			for (Edge<Integer> e : vv.getEdges()) {
				if (vv.id == e.getVertex1().id)
					vv2 = e.getVertex2();
				else
					vv2 = e.getVertex1();

				if(visited[(int) vv2.id] == 0) {
					queue.add((int) vv2.id);
					visited[(int) vv2.id] = visited[(int) vv.id] + 1;
				}

				if (vv2.id == d)
					return visited[(int) vv2.id] - 1;
			}
		}

		return count;
	}

	//main routine
	int minMove() {
		//matrix movement
		int[][] movement = {{-1, 0}, //up
	                        {1, 0},  //down
	                        {0, 1},  //right
	                        {0, -1}  //left
	                       };

	   	int source = 0;
	    int dest = 0;

	    graph = new GraphAdv<Integer>(false);

	    /*
	    * store each matrix position (i,j) as graph node and matrix (i,j)
	    * value as vertex data
	    */
	    for (int i = 0; i < matrix.length; i++) {
		    	for (int j = 0; j < matrix[0].length; j++) {
		    		int id1 = i*10 + j;
	
		    		for (int k = 0; k < movement.length; k++) {
		    			int x = i + movement[k][0];
		    			int y = j + movement[k][1];
	
		    			//valid movement
		    			if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[i][j] != 0) {
		    				int id2 = x*10 + y;
		    				graph.addEdge(id1, id2, 0);
		    				graph.setDataVertex(id1, matrix[i][j]);
		    			}
		    		}
	
		    		//find source vertex and destination vertex
		    		if (matrix[i][j] == 1)
		    			source = i*10+j;
		    		if (matrix[i][j] == 2)
		    			dest = i*10+j;
		    	}
	    }

	    //use bfs to find the shortest path from source to destination
	    return bfs(source, dest);
	}
}