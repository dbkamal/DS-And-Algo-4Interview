package binary_tree;

public class BinaryTreeToDLL {

	static Node2 util(Node2 node) {
		if (node == null)
			return node;

		if (node.left != null) {
			Node2 left = util(node.left);

			for (; left.right != null; left = left.right);

			left.right = node;
			node.left = left;
		}

		if (node.right != null) {
			Node2 right = util(node.right);

			for (; right.left != null; right = right.left);

			node.right = right;
			right.left = node;
		}
		return node;
	}

	static void binaryTreeToDLL (Node2 node) {
		if (node == null)
			return;
		
		Node2 list = util(node);
		
		while (list.left != null) {
			list = list.left;
		}
		
		while (list != null) {
			System.out.println(list.key);
			list = list.right;
		}
	}
	
	public static void main (String[] args) {
		Node2 root = new Node2(10);
        root.left = new Node2(12); 
        root.right = new Node2(15); 
        root.left.left = new Node2(25); 
        root.left.right = new Node2(30); 
        root.right.left = new Node2(36);
        binaryTreeToDLL(root);
	}
}

class Node2 {
	int key;
	Node2 left, right;
	
	Node2 (int key) {
		this.key = key;
		left = right = null;
	}
}
