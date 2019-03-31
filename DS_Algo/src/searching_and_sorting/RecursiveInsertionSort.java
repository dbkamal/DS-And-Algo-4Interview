package searching_and_sorting;

import java.util.Arrays;

public class RecursiveInsertionSort {
	public static void recursiveInsertionSort(int[] arr, int n) {
		if (n > 0) {
			recursiveInsertionSort(arr, n - 1);
			insert(arr, n);
		}
	}

	public static void insert(int[] arr, int i) {
		int key = arr[i];
		int j = i - 1;
		while (j >= 0 && arr[j] > key) {
			arr[j + 1] = arr[j];
			j--;
			arr[j + 1] = key;
		}
		
		System.out.println(Arrays.toString(arr));
	}
}
