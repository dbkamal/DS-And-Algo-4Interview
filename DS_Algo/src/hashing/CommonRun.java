package hashing;

import java.util.ArrayList;

//import java.util.LinkedList;

public class CommonRun {

	public static void main(String[] args) {

		int[] arr = {0, 0, 1, 1, 0};
		ArrayList<Integer> list = LongestSubArray0s1s.longSubArray(arr);
		for(Integer p : list)
			System.out.println(p);
		/*
		int[] arr = {3,2,1,4,5};
		System.out.println(LongestConSubSeq.longestConSubSeq(arr));
		*/
		
		/*
		int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
		System.out.println(LargestSubarray.subarray(arr));
		*/
		
		/*
		int[] arr = {3, 1, 4, 4, 5, 2, 6, 1};
		MostOccurance obj = new MostOccurance();
		int[] result = obj.mostOccurane(arr, 2);
		System.out.println(java.util.Arrays.toString(result));
		*/
		
		/*
		String[] arr = {"geeks", "for", "geeks", "for", "geeks", "aaa"};
		SecondMostRepeated obj = new SecondMostRepeated();
		System.out.println(obj.secondMost(arr));
		*/
		
		/*
		String[] words = { "may", "student", "students", "dog",
                "studentssess", "god", "cat", "act",
                "tab", "bat", "flow", "wolf", "lambs",
                "amy", "yam", "balms", "looped", 
                "poodle"};
		GroupingWords obj = new GroupingWords();
		obj.groupWords(words);
		*/
		
		/*
		int[] arr1 = {1,2,4,4};
		int[] arr2 = {4,2,4,4};
		SameArrays obj = new SameArrays();
		System.out.println(obj.isSameArrays(arr1, arr2));
		*/
		
		/*
		int[] arr = {1,2,3,1,1};
		DuplicateChecking obj = new DuplicateChecking();
		System.out.println(obj.isDuplicate2(arr, 3));
		/*
		int[][] matrix = {{-1,1},{0,0},{1,1},{2,2},{3,3},{3,4}};
		MaxPoint obj = new MaxPoint();
		int count = obj.maxPointOnLine(matrix);
		System.out.println(count);
		*/
		
		/*
		int[] arr = {1,2,4,4};
		SumInArray obj = new SumInArray();
		boolean flag = obj.isSumInArray(arr, 7);
		
		if(flag)
			System.out.println("sum found");
		else
			System.out.println("sum is not found");
		*/
		
		/*
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
		LinkedList<Integer> listInt = obj.intersection(list1, list2);
		LinkedList<Integer> listUni = obj.union(list1, list2);
		obj.unionAndIntersection(list1, list2);
		
		for (Integer p : listInt)
			System.out.println(p);
		
		System.out.println("*****");
		
		for (Integer p : listUni)
			System.out.println(p);
		*/
		
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
