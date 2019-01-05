package hashing;

import java.util.*;

public class SecondMostRepeated {
	String secondMost (String[] arr) {
		HashMap<String, Integer> map = new HashMap<String, Integer> ();
		int max = 0;
		int second = 0;

		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i])+1);
			}
			else
				map.put(arr[i], 1);
		}

		Set<Map.Entry<String, Integer>> mapSet = map.entrySet();
		for (Map.Entry<String, Integer> m : mapSet) {
			if (m.getValue() > max) {
				second = max;
				max = m.getValue();
			}
			else if (m.getValue() > second && m.getValue() != max)
				second = m.getValue();
		}

		for (Map.Entry<String, Integer> m : mapSet) {
			if (m.getValue() == second)
				return m.getKey();
		}
		
		return "";
	}
}