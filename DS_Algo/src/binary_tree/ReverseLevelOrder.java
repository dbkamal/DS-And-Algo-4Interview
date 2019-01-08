package binary_tree;

import java.util.*;

public class ReverseLevelOrder {
	static void reverseLevelOrder(Node root) {
		Queue<Node> queue = new LinkedList<Node> ();
		Stack<Node> stack = new Stack<Node> ();

		if (root == null)
			return;

		queue.add(root);

		while (queue.size() > 0) {
			Node temp = queue.poll();
			stack.push(temp);

			if (temp.right != null)
				queue.add(temp.right);
			
			if (temp.left != null)
				queue.add(temp.left);
		}

		while (stack.size() > 0) {
			Node temp = stack.pop();
			System.out.println(temp.key);
		}
	}
}