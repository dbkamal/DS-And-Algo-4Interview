package misc;

public class MedianSortedArray {

	static int median (int[] arr, int l, int h) {
		int n = (l+h+2)/2;

		return n-1;
	}

	static int medianSortedArray (int[] arr1, int low1, int high1, int[] arr2, int low2, int high2) {

		int diff1 = high1 - low1;
		int diff2 = high2 - low2;

		if (diff1 != diff2) {
			System.out.println("not possible to calculate");
			return -1;
		}

		if (diff1 < 0)
			return -1;

		if (diff1 == 0)
			return (arr1[low1]+arr2[low2] / 2);

		if (diff1 == 1) {
			return (Math.max(arr1[low1], arr2[low2]) + Math.min(arr1[high1], arr2[high2])) / 2;
		}

		int m1 = median(arr1, low1, high1);
		int m2 = median(arr2, low2, high2);

		if (arr1[m1] == arr2[m2]) {
			System.out.println(arr1[m1]);
			return arr1[m1];
		}
		else if (arr1[m1] > arr2[m2])
			return medianSortedArray(arr1, low1, m1, arr2, m2, high2);
		else
			return medianSortedArray(arr1, m1, high1, arr2, low2, m2);
	}

	public static void main (String[] args) {
		int[] arr1 = {1,2,3,4};
		int[] arr2 = {5,6,7,8};
		System.out.println(medianSortedArray(arr1, 0, arr1.length-1, arr2, 0, arr2.length-1));
	}
}