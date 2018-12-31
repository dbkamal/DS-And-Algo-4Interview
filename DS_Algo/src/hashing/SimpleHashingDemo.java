package hashing;

public class SimpleHashingDemo {

	static int[][] hashTable;
	static int ROWS = 100;

	static boolean search(int key) {
		int index = hashFunction(key);

		if ((key > 0 && hashTable[index][0] == key) ||
			(key < 0 && hashTable[index][1] == key))
			return true;

		return false;
	}

	//Simple hash function -division method
	static int hashFunction(int key) {
		return Math.abs(key) % ROWS;
	}

	/*
	* Key can be +ive or -ive
	* column 0 will store the +ive keys
	* column 1 will store the -ive keys
	*/
	static void insert(int p) {
		//convert the key into hash index using hash function
		int index = hashFunction(p);

		if (p > 0)
			hashTable[index][0] = p;
		else
			hashTable[index][1] = p;
	}

	public static void main(String[] args) {
		int[] list = {-2, 10, 33, -543};
		hashTable = new int[ROWS][2];

		for (int i = 0; i < list.length; i++)
			insert(list[i]);

		boolean isFound = search(-543);

		if(isFound)
			System.out.println("found");
		else
			System.out.println("not found");
	}
}