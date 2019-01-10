package binary_tree;

import java.util.*;

public class BST {
	
	static Node inorderSuccessor (Node search) {
		if (search == null)
			return search;
		
		if (search.left != null)
			return inorderSuccessor (search.left);
		else
			return search;
	}
	
	static Node searchParent (Node node, Node search) {
		
		if (node == null)
			return null;
		
		if (node.left == null && node.right == null && node.key == search.key)
			return search;
		else if (node.left == null && node.right == null)
			return null;
		
		if (node.key == search.key)
			return search;
		
		Queue<Node> queue = new LinkedList<Node> ();
		queue.add(node);
		
		while (queue.size() > 0) {
			Node temp = queue.poll();
			
			if (temp.left != null)
				if (temp.left.key == search.key)
					return temp;
				else
					queue.add(temp.left);
			
			if (temp.right != null)
				if (temp.right.key == search.key)
					return temp;
				else
					queue.add(temp.right);
		}
		
		return null;
	}

	static Node search (Node node, int key) {
		if (node == null)
			return node;
		
		if (node.key == key)
			return node;
		
		if (node.key > key) {
			return search(node.left, key);
		}
		else if (node.key < key)
			return search(node.right, key);
		
		return null;
	}
	
	static void insert (Node node, int key) {
		if (node == null)
			node = new Node(key);
		
		if (node.key > key) {
			if (node.left != null)
				insert(node.left, key);
			else
				node.left = new Node(key);
		}
		else if (node.key < key) {
			if (node.right != null)
				insert(node.right, key);
			else
				node.right = new Node(key);
		}
	}
	
	static void delete (Node node, int key) {
		Node deleted = search(node, key);
		Node parent = searchParent(node, deleted);
		
		if (deleted != null) {
			//check if it's a leaf node
			if (deleted.left == null && deleted.right == null) {
				if (parent.left != null && parent.left.key == deleted.key)
					parent.left = null;
				else if (parent.right != null && parent.right.key == deleted.key)
					parent.right = null;

				deleted = null;
			}
			//check if it has one child
			else if (deleted.left != null && deleted.right == null) {
				parent.left = deleted.left;
				deleted = null;
			}
			else if (deleted.left == null && deleted.right != null) {
				parent.right = deleted.right;
				deleted = null;
			}
			//check if it has both children
			else if (deleted.left != null && deleted.right != null) {
				Node inorderSuccessorNode = inorderSuccessor(deleted.right);
				Node parentSuccessorNode = searchParent(node, inorderSuccessorNode);
				
				if (inorderSuccessorNode.right != null)
					parentSuccessorNode.left = inorderSuccessorNode.right;
				
				inorderSuccessorNode.left = deleted.left;
				inorderSuccessorNode.right = deleted.right;
				deleted = null;
			}
		}
		
		TreeStart.inOrder(node);
	}
}
