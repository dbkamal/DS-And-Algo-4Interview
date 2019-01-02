package hashing;

import java.util.*;

/* 
*  Given two Linked Lists, create union and 
*  intersection lists that contain union and 
*  intersection of the elements present in the 
*  given lists. Order of elements in output 
*  lists doesn’t matter.
*/

public class UnionIntersection {

	LinkedList<Integer> intersectionList;
	HashMap<Integer, Integer> hashMap;

	//return the intersection of two sets
	LinkedList<Integer> intersection(LinkedList<Integer> list1, LinkedList<Integer> list2) {

		intersectionList = new LinkedList<Integer> ();
		HashSet<Integer> hashSet = new HashSet<Integer> ();

		//create hash entry based on list1
		for (Integer p : list1)
			hashSet.add(p);

		//search for common element on list2
		for (Integer p : list2) {
			if (hashSet.contains(p))
				intersectionList.add(p);
		}

		return intersectionList;
	}

	LinkedList<Integer> union(LinkedList<Integer> list1, LinkedList<Integer> list2) {

		LinkedList<Integer> unionList = new LinkedList<Integer> ();
		intersectionList = intersection(list1, list2);

		//iterate both linked list and make an entry into union list
		for (Integer p : list1)
			unionList.add(p);

		for (Integer p : list2)
			unionList.add(p);

		//remove the common element from the union all
		for (Integer p : intersectionList)
			unionList.remove(p);

		return unionList;
	}
	
	void makeHashTableEntry(LinkedList<Integer> list) {
		for (Integer p : list) {
			if (hashMap.containsKey(p)) {
				int value = (int) hashMap.get(p);
				hashMap.put(p, value+1);
			}
			else
				hashMap.put(p, 1);
		}
	}
	
	/*
	 * Optimized step
	 */
	void unionAndIntersection(LinkedList<Integer> list1, LinkedList<Integer> list2) {
		
		hashMap = new HashMap<Integer, Integer> ();
		makeHashTableEntry(list1);
		makeHashTableEntry(list2);
		
		Set<Integer> unionList = hashMap.keySet();
		System.out.println("union");
		for (Integer p : unionList)
			System.out.println(p);
		
		System.out.println("intersect");
		Set<Map.Entry<Integer, Integer>> mapEntry = hashMap.entrySet();
		for (Map.Entry<Integer, Integer> map : mapEntry) {
			if (map.getValue() > 1)
				System.out.println(map.getKey());
		}
		
	}
}