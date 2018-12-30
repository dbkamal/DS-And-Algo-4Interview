package numTheory;

import java.util.*;
/*
 * https://www.careercup.com/question?id=6017875829587968
 */
public class FindSmallestBinaryDigit {
	
	/*
	 * Time Complexity - O(2^n) where n = 32 or 64 bit computer.
	 */
	public int findSmallestDigit (int k) {
		Set<Integer> numList = new TreeSet<Integer> ();
		numList.add(0);
		numList.add(1);
		
		for (int i = 10; i < 1111111111; i = i * 10) {
			HashSet<Integer> newList = new LinkedHashSet<Integer> ();
			
			for(Integer n : numList) {
				newList.add(n + i);
			}
			
			for(Integer n : newList) {
				if (n != 0 && n % k == 0) {
					return n;
				}
			}
			numList.addAll(newList);
		}
		return -1;
	}
	
	/*
	 * Another approach: optimized step
	 */
	public int findSmallestDigit2 (int k) {
		
		LinkedList<Integer> queue = new LinkedList<Integer> ();
		Vector<Integer> visited = new Vector<Integer> ();
		
		queue.add(1);
		
		while (queue.size() > 0) {
			int p = queue.pollFirst();
			int rem = p % k;
			
			if (rem == 0)
				return p;
			else {
				if (!visited.contains(rem)) {
					visited.add(rem);
					queue.add(p * 10 + 0);
					queue.add(p * 10 + 1);
				}
			}
		}
		
		return 0;
	}
}
