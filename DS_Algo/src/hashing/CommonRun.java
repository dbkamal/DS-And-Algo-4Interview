package hashing;

public class CommonRun {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right = new Node(3);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.right.left = new Node(8);
		root.right.right.right = new Node(9);

		PrintVerticalOrder obj = new PrintVerticalOrder(root);
		obj.calculateHorizontalDistance(root, 0);
		obj.printVerticalOrder();
	}

}
