package hashing;

import java.util.*;

public class GroupingWords {

	String getKey(String str) {
		
		String key = "";
		boolean[] visited = new boolean[26];

		for(int i = 0; i < str.length(); i++) {
			visited[str.charAt(i) - 'a'] = true;
		}

		for (int i = 0; i < visited.length; i++) {
			if (visited[i])
				key = key + (char) (i+'a');
		}

		return key;
	}

	void groupWords(String[] arr) {
		
		HashMap<String, ArrayList<String>> hashMap = new HashMap<String, ArrayList<String>>();
		for (int i = 0; i < arr.length; i++) {
			String key = getKey(arr[i]);
	
			if (hashMap.containsKey(key)) {
				ArrayList<String> oldList = hashMap.get(key);
				oldList.add(arr[i]);
				hashMap.put(key, oldList);
			}
			else {
				ArrayList<String> newList = new ArrayList<String> ();
				newList.add(arr[i]);
				hashMap.put(key, newList);
			}
		}
	
		Collection<ArrayList<String>> arrayList = hashMap.values();
		for (ArrayList<String> list : arrayList) {
			for (String str : list) {
				System.out.print(str + " ");
			}
			System.out.println("");
		}
	}
}