package hashing;

import java.util.*;

/* Given two arrays: arr1[0..m-1] and arr2[0..n-1]. 
*  Find whether arr2[] is a subset of arr1[] or not. 
*  Both the arrays are not in sorted order. 
*  It may be assumed that elements in both array are distinct.
*  Consider- there is no duplicate element in the both arrays
*/

public class SubsetArray {

	boolean isSubset(int[] arr1, int[] arr2) {

		//insert arr1 into hashtable
		HashSet<Integer> hashTable = new HashSet<Integer> ();
		for (int i = 0; i < arr1.length; i++)
			hashTable.add(arr1[i]);

		// search all elements of arr2 into arr1
		for (int j = 0; j < arr2.length; j++) {
			if (!hashTable.contains(arr2[j]))
				return false;
		}

		return true;
	}
	
	/*
	* this method handles the duplicate entry
	* sort both the arrays and do the merging
	*/
	boolean isSubsetWithDups(int[] arr1, int[] arr2) {
		//sort both arrays
		Arrays.sort(arr1);
		Arrays.sort(arr2);

		//merging process
		int i, j;
		i = j = 0;
		
		//edge cases if either of the array is empty or
		//array1 is smaller in size than array2
		if (arr1.length == 0 || arr2.length == 0 || arr1.length < arr2.length)
			return false;

		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] < arr2[j])
				i++;
			else if (arr1[i] == arr2[j]) {
				i++;
				j++;
			}
			else if (arr1[i] > arr2[j])
				return false;
		}
		
		return true;
	}
}