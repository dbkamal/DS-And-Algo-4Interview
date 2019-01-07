package binary_tree;

import java.util.*;

public class PrintPostOrder {
	
	static int index = 0;
	private static ArrayList<Integer> list = new ArrayList<Integer> ();
	
	static void finalPostPrint(int[] in, int[] pre, HashMap<Integer, Integer> map, int start, int end) {
		if (start > end)
			return;
		
		int postIndex = map.get(pre[index]);
		index++;
		
		//traverse left tree
		finalPostPrint(in, pre, map, start, postIndex-1);
		
		//traverse right tree
		finalPostPrint(in, pre, map, postIndex+1, end);
		
		list.add(in[postIndex]);
	}
	
	static ArrayList<Integer> printPostOrder(int[] in, int[] pre) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer> ();
		int start = 0;
		int end = in.length-1;
		for (int i = 0; i < in.length; i++)
			map.put(in[i], i);
		
		finalPostPrint(in, pre, map, start, end);
		return list;
	}
}
