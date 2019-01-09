package binary_tree;

public class BoundaryTraversal {

	static void printRightSide(Node root) {
		if (root != null) {
			if (root.right != null) {
				System.out.println(root.key);
				printRightSide(root.right);
			}
			else if (root.left != null) {
				System.out.println(root.key);
				printRightSide(root.left);
			}
		}
	}
	
	static void printLeafNode(Node root) {
		if (root != null) {
			printLeafNode(root.left);
			
			if (root.left == null && root.right == null)
				System.out.println(root.key);
			
			printLeafNode(root.right);
		}
	}
	
	static void printLeftSide(Node root) {
		if (root != null) {
			if (root.left != null) {
				System.out.println(root.key);
				printLeftSide(root.left);
			}
			else if (root.right != null) {
				System.out.println(root.key);
				printLeftSide(root.right);
			}
		}
	}
	
	static void boundaryTraversal(Node root) {
		if (root == null)
			return;
		
		System.out.println(root.key);
		
		printLeftSide(root.left);
		printLeafNode(root.left);
		printLeafNode(root.right);
		printRightSide(root.right);
	}
}
