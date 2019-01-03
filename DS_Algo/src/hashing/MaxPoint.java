package hashing;

import java.util.*;

/* 
*  Given an array A[] and a number x, 
*  check for pair in A[] with sum as x
*/

public class MaxPoint {

	int calculateGcd(int a, int b) {
		//handle negative values
		a = Math.abs(a);
		b = Math.abs(b);

		//handle edge cases
		if (a == 0)
			return b;
		if (b == 0)
			return a;
		if (a == 0 && b == 0)
			return Integer.MAX_VALUE;

		while (a != b) {
			if (a > b)
				a = a - b;
			else
				b = b - a;
		}

		return a;
	}

	int maxPointOnLine(int[][] matrix) {

		int slope;
		int max = 0;
		HashMap<Integer, Map<Integer, Integer>> hashMap = new HashMap<Integer, Map<Integer, Integer>> ();
		
		if (matrix.length == 0)
			return 0;
		if (matrix.length == 1)
			return 1;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = i+1; j < matrix.length; j++) {
				int x = matrix[j][0] - matrix[i][0];
				int y = matrix[j][1] - matrix[i][1];
				slope = calculateGcd(y, x);
				
				if (slope != 0) {
					x /= slope;
					y /= slope;
				}
				
				if (hashMap.containsKey(x)) {
					if (hashMap.get(x).containsKey(y)) {
						hashMap.get(x).put(y, hashMap.get(x).get(y)+1);
					}
					else {
						hashMap.get(x).put(y, 1);
					}
				}
				else {
					Map<Integer, Integer> newMap = new HashMap<Integer, Integer> ();
					newMap.put(y, 1);
					hashMap.put(x, newMap);
				}
				max = Math.max(max, hashMap.get(x).get(y));
			}
		}

		return max;
	}
}