package misc;

public class RotateMatrix {
	
	public static void inplaceRotateMatrix (int[][] matrix, int n) {
		for (int layer = 0; layer < n/2; layer++) {
			int first = layer;
			int last = n-1-layer;
			
			for (int i = first; i < last; i++) {
				int offset = i - first;
				int top = matrix[first][i];
				
				//bottom -> top
				matrix[first][i] = matrix[last-offset][first];
				//bottom right ->left
				matrix[last-offset][first] = matrix[last][last-offset];
				//top to bottom
				matrix[last][last-offset] = matrix[i][last];
				matrix[i][last] = top;
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + "   ");
			}
			System.out.println();
		}
	}
	
	public static void rotateMatrix (int[][] matrix, int n) {
		int[][] dest = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				dest[j][n-i-1] = matrix[i][j];
			}
		}
		
		matrix = dest;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + "   ");
			}
			System.out.println();
		}
	}
}
