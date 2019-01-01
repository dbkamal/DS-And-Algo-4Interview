package hashing;

import java.util.*;

public class PrintVerticalOrder {

	TreeMap<Integer, ArrayList<Integer>> treeMap;
	Node root;
	int hd = 0;

	PrintVerticalOrder (Node node) {
		treeMap = new TreeMap<Integer, ArrayList<Integer>> ();
		root = node;
	}

	void calculateHorizontalDistance(Node node, int hd) {
		
		if (node == null)
			return;
		
		ArrayList<Integer> list;
		
		if (treeMap.containsKey(hd))
			list = treeMap.get(hd);
		else
			list = new ArrayList<Integer> ();
		
		list.add(node.data);
		treeMap.put(hd, list);
		calculateHorizontalDistance(node.left, -1+hd);
		calculateHorizontalDistance(node.right, 1+hd);
	}

	void printVerticalOrder() {
		Collection<ArrayList<Integer>> c = treeMap.values();

		for (ArrayList<Integer> cc : c) {
			for (Integer p : cc) {
				System.out.print(p + " ");
			}
			System.out.println();
		}
	}
}

/*
class BinaryTree {

	Node root;
	
	BinaryTree(Node root) {
		this.root = root;
	}

	void printInorder(Node node) {
		if (node == null)
			return;

		printInorder(node.left);
		System.out.print(node.data + " ");
		printInorder(node.right);
	}
}
*/

class Node {
	int data;
	Node left, right;

	Node (int data) {
		this.data = data;
		left = right = null;
	}
}