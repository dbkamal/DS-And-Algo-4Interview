package numTheory;

import java.util.*;
/*
 * https://www.careercup.com/question?id=6017875829587968
 */
public class FindSmallestBinaryDigit {
	public int findSmallestDigit(int k) {
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
}
