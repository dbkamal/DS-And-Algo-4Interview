package hashing;

import java.util.*;

public class DuplicateChecking {
	
	boolean isDuplicate2 (int[] arr, int k) {
		HashSet<Integer> hashSet = new HashSet<Integer> ();
		
		for (int i = 0; i < arr.length; i++) {
			if (hashSet.contains(arr[i]))
				return true;
			else {
				hashSet.add(arr[i]);
			}
			
			if (i >= k)
				hashSet.remove(arr[i-k]);
		}
		
		return false;
	}
	
	boolean isDuplicate (int[] arr, int k) {
		HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<Integer, ArrayList<Integer>> ();
		
		for (int i = 0; i < arr.length; i++) {
			if (hashMap.containsKey(arr[i])) {
				ArrayList<Integer> oldList = hashMap.get(arr[i]);
				if (i - oldList.get(oldList.size()-1) <= k)
					return true;
			}
			else {
				ArrayList<Integer> list = new ArrayList<Integer> ();
				list.add(i);
				hashMap.put(arr[i], list);
			}
		}
		
		return false;
	}
}