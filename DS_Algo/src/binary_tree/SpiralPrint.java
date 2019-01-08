package binary_tree;

import java.util.*;

public class SpiralPrint {
	static void spiralPrint(Node root) {
		Stack<Node> s1 = new Stack<Node> ();
		Stack<Node> s2 = new Stack<Node> ();
		
		s1.add(root);
		
		while (!s1.isEmpty() || !s2.isEmpty()) {
			while(!s1.isEmpty()) {
				Node temp = s1.pop();
				System.out.println(temp.key);
				
				if (temp.right != null)
					s2.add(temp.right);
				
				if (temp.left != null)
					s2.add(temp.left);
			}
			
			while (!s2.isEmpty()) {
				Node temp = s2.pop();
				System.out.println(temp.key);
				
				if (temp.left != null)
					s1.add(temp.left);
				
				if (temp.right != null)
					s1.add(temp.right);
			}
		}
	}
}
