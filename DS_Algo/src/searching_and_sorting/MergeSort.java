package searching_and_sorting;

import java.util.*;

public class MergeSort {
	public static void merge(int[] arr, int start, int mid, int end) {
		int[] left = new int[mid - start + 1];
		int[] right = new int[end - mid];

		/** Copy the collection data into temp array */
		for (int i = 0; i < left.length; i++)
			left[i] = arr[start + i];

		for (int i = 0; i < right.length; i++)
			right[i] = arr[mid + 1 + i];

		/** compare each sorted list and choose the smaller number */
		int i = 0, j = 0, k = 0;
		while (i < left.length && j < right.length && k < arr.length) {
			if (left[i] < right[j])
				arr[start + k] = left[i++];
			else
				arr[start + k] = right[j++];
			k++;
		}

		/** if any sorted list is already exhausted, then copy rest of the element from the other list */
		while (i < left.length) {
			arr[start + k] = left[i++];
			k++;
		}

		while (j < right.length) {
			arr[start + k] = right[j++];
			k++;
		}
		
		System.out.println(Arrays.toString(arr));
	}
	
	/** Main Sub-Routine */
	public static void mergeSort(int[] arr, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(arr, start, mid);
			mergeSort(arr, mid + 1, end);
			merge(arr, start, mid, end);	
		}
	}
}
