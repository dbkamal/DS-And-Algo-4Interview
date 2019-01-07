package binary_tree;

import java.util.*;

public class BTInsertion {
	static void insertNode(Node temp, int value) {
		Queue<Node> queue = new LinkedList<Node> ();
		queue.add(temp);

		while(queue.size() > 0) {
			Node root = queue.poll();
			
			if(root.left == null) {
				root.left = new Node(value);
				break;
			}
			else
				queue.add(root.left);

			if(root.right == null) {
				root.right = new Node(value);
				break;
			}
			else
				queue.add(root.right);
		}
	}
}
