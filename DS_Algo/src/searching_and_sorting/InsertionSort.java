package searching_and_sorting;
/** https://en.wikipedia.org/wiki/Insertion_sort */

import java.util.*;

public class InsertionSort {
	public static void sort(int[] arr) {
		if (arr == null)
			return;

		for(int i = 1; i < arr.length; i++) {
			int key = arr[i];
			/** pointer to traverse left side of the collection */
			int j = i - 1;

			/** traverse left side and compare each element and place into right position */
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j--;
				arr[j + 1] = key;
			}
		}

		System.out.println(Arrays.toString(arr));
	}
}
