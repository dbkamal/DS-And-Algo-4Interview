package hashing;

import java.util.*;

public class LongestSubArray0s1s {
	static ArrayList<Integer> longSubArray(int[] arr) {
		int sum, max, end, start;
		sum = max = end = start = 0;
		int n = arr.length;
		ArrayList<Integer> list = new ArrayList<Integer> ();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer> ();

		for (int i=0; i < n; i++)
			arr[i] = (arr[i] == 0 ? -1 : 1);

		for (int i = 0; i < n; i++) {
			sum += arr[i];

			if (sum == 0) {
				max = i+1;
				end = i;
			}

			if (map.containsKey(sum+n)) {
				if (max < i - map.get(sum+n)) {
					max = i - map.get(sum+n);
					end = i;
				}
			}
			else
				map.put(sum+n, i);
		}

		//reset array element -1 to 0
		for (int i = 0; i < n; i++)
			arr[i] = (arr[i] == -1 ? 0 : 1);

		start = end-max+1;

		for(int i = start; i <= end; i++) {
			list.add(arr[i]);
		}
		return list;
	}
}
