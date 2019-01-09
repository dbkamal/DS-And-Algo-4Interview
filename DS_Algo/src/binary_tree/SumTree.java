package binary_tree;

public class SumTree {

	static int sumTree(Node node) {
		if (node == null)
			return 0;
		
		int old_val = node.key;
		
		node.key = sumTree(node.left) + sumTree(node.right);
		
		return (node.key + old_val);
	}
}
