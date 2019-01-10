package binary_tree;

import java.util.*;

public class FindLCA {

	static void storeNodePath(Vector<Node> vec, Node node, int n) {
		if (node == null)
			return;
		
		if (node.key == n) {
			vec.add(node);
			return;
		}

		vec.add(node);

		if (node.left != null)
			storeNodePath(vec, node.left, n);

		if (node.right != null)
			storeNodePath(vec, node.right, n);

		vec.remove(vec.size() - 1);
	}

	static void findLCA (Node node, int n1, int n2) {
		Vector<Node> v1 = new Vector<Node> ();
		Vector<Node> v2 = new Vector<Node> ();

		if (n1 == n2) {
			System.out.println("LCA " + n1);
			return;
		}

		storeNodePath(v1, node, n1);
		storeNodePath(v2, node, n2);
		
		System.out.println(v1.size());
		System.out.println(v2.size());

		for (int i = 1; i < v1.size() && i < v2.size(); i++) {
			if (v1.get(i).key != v2.get(i).key) {
				System.out.println("LCA " + v1.get(i-1).key);
				return;
			}

		}
	}
}
