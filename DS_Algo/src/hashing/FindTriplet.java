package hashing;

import java.util.*;

public class FindTriplet {
	static ArrayList<Integer> findTriplet2(int[] arr) {
		ArrayList<Integer> result = new ArrayList<Integer> ();
		for(int i = 0; i < arr.length-1; i++) {
			HashSet<Integer> set = new HashSet<Integer> ();
			for(int j = i+1; j < arr.length; j++) {
				int x = - (arr[i] + arr[j]);
				if(set.contains(x)) {
					result.add(x);
					result.add(arr[i]);
					result.add(arr[j]);
				}
				else
					set.add(arr[j]);
			}
		}
		return result;
	}
	
	static ArrayList<Integer> findTriplet(int[] arr) {
		HashMap<Integer, Integer[]> map = new HashMap<Integer, Integer[]> ();
		ArrayList<Integer> result = new ArrayList<Integer> ();
		boolean[] visited = new boolean[arr.length];

		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				int sum = arr[i] + arr[j];
				if (map.containsKey(sum)) {
					Integer[] oldList = map.get(sum);
					oldList[0] = i;
					oldList[1] = j;
					map.put(sum, oldList);
				}
				else {
					Integer[] newList = {i, j};
					map.put(sum, newList);
				}
			}
		}

		for (int i = 0; i < arr.length; i++) {
			int comp = 0 - arr[i];
			if(map.containsKey(comp)) {
				Integer[] list = map.get(comp);
				if(list[0] != i && list[1] != i && (!visited[i] || !visited[list[0]] || !visited[list[1]])) {
					result.add(arr[list[0]]);
					result.add(arr[list[1]]);
					result.add(arr[i]);
					visited[list[0]] = true;
					visited[list[1]] = true;
					visited[i] = true;
					
				}
			}
		}
		return result;
	}
}
