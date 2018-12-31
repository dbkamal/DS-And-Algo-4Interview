package graph;

public class FindIslands {

	void dfs(int i, int j, boolean[][] visited, int[][] matrix) {

		int[][] movement = {{-1,-1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

		if (!visited[i][j]) {
			visited[i][j] = true;

			for (int k = 0; k < movement.length; k++) {
				int x = i + movement[k][0];
				int y = j + movement[k][1];

				if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[x][y] == 1) {
					if (!visited[x][y]) {
						dfs(x, y, visited, matrix);
					}
				}
			}
		}
	}

	int findNumIslands(int[][] matrix) {
		
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		int count = 0;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 1 && !visited[i][j]) {
					dfs(i, j, visited, matrix);
					count++;
				}
			}
		}

		return count;
	}

}