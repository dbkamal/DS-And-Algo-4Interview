package binary_tree;

import java.util.*;

public class TreeStart {
	
	static void bfs(Node root) {
		Queue<Node> queue = new LinkedList<Node> ();
		queue.add(root);
		
		while(queue.size() > 0) {
			Node temp = queue.poll();
			
			if (temp.left != null)
				queue.add(temp.left);
			
			if (temp.right != null)
				queue.add(temp.right);
			
			System.out.print(temp.key + " ");
		}
	}
	
	static void postOrder(Node root) {
		if (root == null)
			return;
		
		postOrder(root.left);
		postOrder(root.right);
		System.out.println(root.key);
	}
	
	static void inOrder(Node root) {
		if (root == null)
			return;
		
		inOrder(root.left);
		System.out.print(root.key + " ");
		inOrder(root.right);
	}
	
	public static void main(String[] args) {
		
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.right = new Node(7);
		root.left.left.left = new Node(8);
		root.left.right.right = new Node(11);
		root.right.right.left = new Node(10);
		
		ReverseLevelOrder.reverseLevelOrder(root);
		
//		postOrder(root);
		
//		SpiralPrint.spiralPrint(root);
		
		
		/*
		int[] in = {4, 2, 5, 1, 3, 6};
		int[] pre = {1, 2, 4, 5, 3, 6};
		ArrayList<Integer> list = PrintPostOrder.printPostOrder(in, pre);
		for (Integer p : list)
			System.out.println(p);
		*/
		
		/*
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		bfs(root);
		BTInsertion.insertNode(root, 5);
		inOrder(root);
		*/
	}
}

class Node {
	int key;
	Node left, right;
	
	Node(int key) {
		this.key = key;
		left = right = null;
	}
}
