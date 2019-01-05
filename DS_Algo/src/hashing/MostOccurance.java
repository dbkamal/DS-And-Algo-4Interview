package hashing;

import java.util.*;

public class MostOccurance {
	int[] mostOccurane(int[] arr, int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer> ();
		int[] result = new int[k];
		int i = 0;

		for (int j = 0; j < arr.length; j++) {
			if (map.containsKey(arr[j]))
				map.put(arr[j], map.get(arr[j])+1);
			else
				map.put(arr[j], 1);
		}

		Map<Integer, Integer> treeMap = new TreeMap<Integer, Integer> ();
		Set<Map.Entry<Integer, Integer>> mmap = map.entrySet();
		
		for (Map.Entry<Integer, Integer> m : mmap)
			treeMap.put(m.getValue(), m.getKey());

		Collection<Integer> collection = treeMap.values();

		for (Integer p : collection) {
			if (i < k) {
				result[i] = p;
				i++;
			}
			else
				return result;
		}

		return result;
	}
}
