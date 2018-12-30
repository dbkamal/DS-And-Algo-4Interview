package graph;

import java.util.LinkedList;
import java.util.Vector;

public class FindLargestRegion {
	
	int[][] matrix;
	GraphAdvMod<String> graph;

	FindLargestRegion(int[][] matrix) {
		this.matrix = matrix;
	}

	int bfs() {

		LinkedList<String> queue = new LinkedList<String> ();
		Vector<String> visited = new Vector<String> ();
		int count = 0;
		String id = "";

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 1) {
	    				if (i == 0)
	    					id = Integer.toString(i*10) + Integer.toString(j);
	    				else
	    					id = Integer.toString(i*10 + j);
					
					if(!visited.contains(id) && graph.allVertex.containsKey(id)) {
						queue.add(id);
						visited.add(id);
					}
					
					VertexMod<String> vv2 = null;

					while (queue.size() > 0) {
						String v = queue.poll();
						VertexMod<String> vv = graph.allVertex.get((String) v);

						for (EdgeMod<String> e : vv.getEdges()) {
							if (vv.id == e.getVertex1().id)
								vv2 = e.getVertex2();
							else
								vv2 = e.getVertex1();

							if(!visited.contains(vv2.id)) {
								queue.add((String) vv2.id);
								visited.addElement(vv2.id);
								count++;
							}
						}
					}
				}
			}
		}

		return count+1;
	}

	//main routine
	int findLargest() {
		//matrix movement
		int[][] movement = {{-1, 0}, //up
	                        {1, 0},  //down
	                        {0, 1},  //right
	                        {0, -1},  //left
	                        {-1, 1},
	                        {-1, -1},
	                        {1, -1},
	                        {1, 1}
	                       };

	    graph = new GraphAdvMod<String>(false);

	    /*
	    * store each matrix position (i,j) as graph node and matrix (i,j)
	    * value as vertex data
	    */
	    for (int i = 0; i < matrix.length; i++) {
		    	for (int j = 0; j < matrix[0].length; j++) {
		    		String id1 = "";
		    		String id2 = "";
		    		
		    		if (matrix[i][j] == 0)
		    			continue;
		    		
    				if (i == 0)
    					id1 = Integer.toString(i*10) + Integer.toString(j);
    				else
    					id1 = Integer.toString(i*10 + j);
	
		    		for (int k = 0; k < movement.length; k++) {
		    			int x = i + movement[k][0];
		    			int y = j + movement[k][1];
	
		    			//valid movement
		    			if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[x][y] != 0) {
		    				if (x == 0)
		    					id2 = Integer.toString(x*10) + Integer.toString(y);
		    				else
		    					id2 = Integer.toString(x*10 + y);
		    				
		    				graph.addEdge(id1, id2, 0);
		    			}
		    		}
		    	}
	    }

	    //use BFS to find the shortest path from source to destination
	    return bfs();
	}
}
