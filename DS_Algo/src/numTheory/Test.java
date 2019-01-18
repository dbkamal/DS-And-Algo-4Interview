package numTheory;

import java.util.Comparator;
//import java.util.TreeSet;

public class Test {
	public static void main(String[] args) {
//		TreeSet<String> h = new TreeSet<String> (new MyComp());
//		TreeSet<Integer> hi = new TreeSet<Integer> (new MyComp2());
//		h.add("k");
//		h.add("t");
//		h.add("b");
//		
//		hi.add(5);
//		hi.add(7);
//		
//		for (String p : h)
//			System.out.println(p);
//		
//		for (Integer q : hi)
//			System.out.println(q);
//		int[] arr = {0,1,0,1};
//		for (int i=0;i<arr.length;i++)
//			arr[i] = (arr[i] == 0 ? -1 : 1);
//		System.out.println(java.util.Arrays.toString(arr));
//		Integer[] p = {1,2,3};
//		for(Integer q : p)
//			System.out.println(q);
//		String s = "G";
//		char c = s.charAt(0);
//		System.out.println(c + (1 << 5));
		String str = "apple";
		str += '\0';
		
		System.out.println(str.length());
		
	}
}

class MyComp implements Comparator<String> {
	public int compare(String s1, String s2) {
		return s2.compareTo(s1); //reverse the string ordering
	}
}

class MyComp2 implements Comparator<Integer> {
	public int compare(Integer p1, Integer p2) {
		if (p1 == p2)
			return 0;
		else if (p1 < p2)
			return 1;
		else
			return -1;
	}
}
