package hashing;

import java.util.*;

public class SameArrays {
	boolean isSameArrays (int[] arr1, int[] arr2) {
		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer> ();

		if (arr1.length != arr2.length)
			return false;

		for (int i = 0; i < arr1.length; i++) {
			if (hashMap.containsKey(arr1[i])) {
				hashMap.put(arr1[i], hashMap.get(arr1[i]) + 1);
			}
			else
				hashMap.put(arr1[i], 1);
		}

		for (int i = 0; i < arr2.length; i++) {
			if (hashMap.containsKey(arr2[i]) && hashMap.get(arr2[i]) >= 1) {
				hashMap.put(arr2[i], hashMap.get(arr2[i]) - 1);
			}
			else
				return false;
		}
		return true;
	}
}