package hashing;

import java.util.*;

/* 
*  Given an array A[] and a number x, 
*  check for pair in A[] with sum as x
*/

public class SumInArray {

	boolean isSumInArray(int[] arr, int sum) {

		HashSet<Integer> hashSet = new HashSet<Integer> ();

		for (int i = 0; i < arr.length; i++) {
			int complement = sum - arr[i];

			if (hashSet.contains(arr[i]))
				return true;

			hashSet.add(complement);
		}

		return false;
	}
}