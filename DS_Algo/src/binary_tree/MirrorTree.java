package binary_tree;

public class MirrorTree {

	static boolean isMirrorTree (Node node1, Node node2) {
		if (node1 == null && node2 == null)
			return true;
		
		if (node1 == null || node2 == null)
			return false;
		
		return (node1.key == node2.key && 
				isMirrorTree(node1.left, node2.right) && 
				isMirrorTree(node1.right, node2.left));
	}
}
