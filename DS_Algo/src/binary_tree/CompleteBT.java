package binary_tree;

import java.util.*;

public class CompleteBT {

	static boolean isCompleteBinaryTree (Node node) {
		
		Queue<Node> queue = new LinkedList<Node> ();
		boolean isLeaf = false;
		
		if (node == null)
			return false;
		
		queue.add(node);
		
		while (queue.size() > 0) {
			Node temp = queue.poll();
			
			if (temp.left == null && temp.right != null)
				return false;
			
			if (temp.left == null && temp.right == null)
				isLeaf = true;
			
			if (temp.left != null && !isLeaf)
				queue.add(temp.left);
			else
				return false;
			
			if (temp.right != null && !isLeaf)
				queue.add(temp.right);
			else
				return false;
		}
		
		return true;
	}
}
