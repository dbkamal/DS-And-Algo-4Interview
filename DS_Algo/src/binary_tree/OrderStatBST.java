package binary_tree;

import java.util.Stack;

public class OrderStatBST {
	
	static int count = 0;
	
	static int inOrderStat (Node node, int k) {
		
		Stack<Node> s = new Stack<Node> ();
		
		if (k <= 0)
			return k;
		
		if (node != null)
			s.push(node);
		else
			return -1;
		
		while (node.left != null) {
			s.push(node.left);
			node = node.left;
		}
		
		while (s.size() > 0) {
			Node temp = s.pop();
			count++;
			
			if (count == k)
				return temp.key;
			
			if (temp.right != null) {
				s.push(temp.right);
				Node n = temp.right;
				
				while (n.left != null) {
					s.push(n.left);
					n = n.left;
				}
			}
		}
		
		return -1;
	}
}
