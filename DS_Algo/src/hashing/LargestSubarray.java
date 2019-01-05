package hashing;

import java.util.*;

public class LargestSubarray {
	static int subarray(int[] arr) {
		int sum = 0;
		int max_length = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer> ();

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];

			if (arr[i] == 0 && max_length == 0)
				max_length = 1;

			if (sum == 0)
				max_length = i+1;

			Integer prev_index = map.get(sum);

			if (prev_index != null)
				max_length = Math.max(max_length, i-prev_index);
			else
				map.put(sum, i);
		}
		return max_length;
	}
}
