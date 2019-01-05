package hashing;

import java.util.*;

public class LongestConSubSeq {
	static int longestConSubSeq (int[] arr) {
		HashMap<Integer, Boolean> set = new HashMap<Integer, Boolean> ();
		int count;
		int max = 1;
		
		if (arr.length == 0)
			return 0;
		
		for (int i = 0; i < arr.length; i++)
			set.put(arr[i], false);

		for (int i = 0; i < arr.length && !set.get(arr[i]); i++) {
			count = 1;
			//decrement the element and do lookup in hashtable
			int key = arr[i] - 1;
			while(set.containsKey(key)) {
				set.put(key, true);
				count++;
				key--;
			}

			//increment the element and do lookup in hashtable
			int newKey = arr[i] + 1;
			while(set.containsKey(newKey)) {
				set.put(newKey, true);
				count++;
				newKey++;
			}

			if (count > max)
				max = count;

			set.put(arr[i], true);
		}
		return max;
	}
}
