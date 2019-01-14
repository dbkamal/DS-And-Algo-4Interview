package greedy_algo;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HuffmanCodingDemo {
	
	static void printCode(HuffmanNode root, String s) {
		if (root.left == null && root.right == null && Character.isLetter(root.c)) {
			System.out.println(root.c + ":" + s);
			return;
		}
		
		printCode(root.left, s+'0');
		printCode(root.right, s+'1');
	}

	public static void main (String[] args) {
		char[] charArray = {'a','b','c','d','e','f'};
		int[] charFreq = {5,9,12,13,16,45};
		int n = charArray.length;
		PriorityQueue<HuffmanNode> queue = 
				new PriorityQueue<HuffmanNode> (new MyComparator());
		
		for (int i = 0; i < n; i++) {
			HuffmanNode huff = new HuffmanNode();
			huff.data = charFreq[i];
			huff.c = charArray[i];
			huff.left = huff.right = null;
			queue.add(huff);
		}
		
		HuffmanNode root = null;
		
		while (queue.size() > 1) {
			HuffmanNode x = queue.poll();
			HuffmanNode y = queue.poll();
			HuffmanNode f = new HuffmanNode();
			f.data = x.data + y.data;
			f.c = '-';
			f.left = x;
			f.right = y;
			root = f;
			queue.add(f);
		}
		printCode(root, "");
	}
}

class HuffmanNode {
	int data;
	char c;
	HuffmanNode left;
	HuffmanNode right;
}

class MyComparator implements Comparator<HuffmanNode> {
	public int compare(HuffmanNode o1, HuffmanNode o2) {
		return o1.data - o2.data;
	}
}