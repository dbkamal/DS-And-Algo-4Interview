package binary_tree;

import java.util.Stack;

public class MergeTwoBST {

	static void merge(Node node1, Node node2) {
		
		Stack<Node> s1 = new Stack<Node> ();
		Stack<Node> s2 = new Stack<Node> ();
		
		Node currNode1, currNode2, temp1, temp2;
		currNode1 = node1;
		currNode2 = node2;
		temp1 = temp2 = null;
		
		//print node2 via in-order traversal
		if (currNode1 == null)
			TreeStart.inOrder(currNode2);
		
		if (currNode2 == null)
			TreeStart.inOrder(currNode1);
		
		s1.add(currNode1);
		s2.add(currNode2);
		
		//add left tree nodes until null
		while (currNode1.left != null || currNode2.left != null) {
			if (currNode1.left != null) {
				s1.push(currNode1.left);
				currNode1 = currNode1.left;
			}
			
			if (currNode2.left != null) {
				s2.push(currNode2.left);
				currNode2 = currNode2.left;
			}
		}
		
		while (s1.size() > 0 || s2.size() > 0) {
			
			if (s1.size() > 0)
				temp1 = s1.pop();
			else
				temp1 = null;
			
			if (s2.size() > 0)
				temp2 = s2.pop();
			else
				temp2 = null;
			
			if (temp1 == null && temp2 != null) {
				temp2.left = null;
				TreeStart.inOrder(temp2);
				continue;
			}
			
			if (temp2 == null && temp1 != null) {
				temp1.left = null;
				TreeStart.inOrder(temp1);
				continue;
			}
			
			if (temp1.key > temp2.key) {
				System.out.println(temp2.key);
				s1.push(temp1);
				if (temp2.right != null) {
					Node n = temp2.right;
					s2.push(n);
					while (n.left != null) {
						s2.push(n.left);
						n = n.left;
					}
				}
			}
			else if (temp2.key > temp1.key) {
				System.out.println(temp1.key);
				s2.push(temp2);
				if (temp1.right != null) {
					Node n = temp1.right;
					s1.push(n);
					while (n.left != null) {
						s1.push(n.left);
						n = n.left;
					}
				}
			}
		}
	}
}
