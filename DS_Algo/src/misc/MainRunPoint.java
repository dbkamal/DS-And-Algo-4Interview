package misc;

public class MainRunPoint {
	public static void main (String[] args) {
		MyQueue obj = new MyQueue();
		obj.enqueue(10);
		obj.enqueue(20);
		System.out.println(obj.dequeue());
		obj.enqueue(30);
		System.out.println(obj.dequeue());
		
		/*
		TwoStacks obj = new TwoStacks();
		obj.pushStack1(5);
		obj.pushStack2(7);
		obj.popStack1();
		obj.pushStack1(11);
		obj.popStack2();
		obj.pushStack2(13);
		obj.display();
		*/
		/*
		EndLinkedList obj = new EndLinkedList(4);
		obj.addNode(3);
		obj.addNode(2);
		obj.addNode(1);
		obj.addNode(3);
		obj.addNode(0);
		obj.lastNodeFromN(4);
		*/

		/*
		int[][] matrix = {{0,1,2,3},{4,5,6,7}, {8,9,10,11},{12,13,14,15}};
		RotateMatrix.inplaceRotateMatrix(matrix, 4);
		*/
		/*
		char[] ch = {'a','a','a','\0'};
		char[] ch2 = RemoveDuplicateChar.removeDuplicateChar(ch);
		System.out.println(java.util.Arrays.toString(ch2));
		*/
		/*
		char[] ch = {'a','p','p','l','e','\0'};
		char[] reverse = ReverseString.reverseString(ch);
		System.out.println(java.util.Arrays.toString(reverse));
		*/
		/*
		Trie trie = new Trie();
		String[] words = {"abc", "abac", "abt"};
		
		for (String s : words)
			trie.insert(s);
		
		System.out.println(trie.search("cat"));
		System.out.println(trie.search("ab"));
		System.out.println(trie.longestCommonPrefix());
		*/
		/*
		String str = "aple";
		System.out.println(UniqueChar.isUniqChar(str));
		System.out.println(UniqueChar.isUniqChar("apple"));
		*/
	}
}
