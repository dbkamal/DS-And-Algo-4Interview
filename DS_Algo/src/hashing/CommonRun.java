package hashing;

import java.util.LinkedList;

public class CommonRun {

	public static void main(String[] args) {
		
		LinkedList<Integer> list1 = new LinkedList<Integer> ();
		list1.add(10);
		list1.add(15);
		list1.add(4);
		list1.add(20);
		
		LinkedList<Integer> list2 = new LinkedList<Integer> ();
		list2.add(8);
		list2.add(4);
		list2.add(2);
		list2.add(10);
		
		UnionIntersection obj = new UnionIntersection();
//		LinkedList<Integer> listInt = obj.intersection(list1, list2);
//		LinkedList<Integer> listUni = obj.union(list1, list2);
		obj.unionAndIntersection(list1, list2);
		
//		for (Integer p : listInt)
//			System.out.println(p);
//		
//		System.out.println("*****");
//		
//		for (Integer p : listUni)
//			System.out.println(p);
		
		/*
		int[] arr1 = {};
		int[] arr2 = {11};
		SubsetArray obj = new SubsetArray();
		boolean flag = obj.isSubsetWithDups(arr1, arr2);
		if (flag)
			System.out.println("subset found");
		else
			System.out.println("no subset found");
		*/
		
		/*
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
		*/
	}

}
