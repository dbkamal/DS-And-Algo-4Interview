package misc;

public class HeapDemo {
	
	static void maxHeapify (int[] arr, int n, int i) {
		int l = 2*i + 1;
		int r = 2*i + 2;
		int maxIndex;

		if (l < n && arr[l] > arr[i])
			maxIndex = l;
		else
			maxIndex = i;

		if (r < n && arr[maxIndex] < arr[r])
			maxIndex = r;

		if (maxIndex != i) {
			//swap
			int temp = arr[maxIndex];
			arr[maxIndex] = arr[i];
			arr[i] = temp;
			maxHeapify (arr, n, maxIndex);
		}
	}

	static void minHeapify (int[] arr, int i) {
		int l = 2*i+1;
		int r = 2*i+2;
		int min;

		if (l < arr.length && arr[l] < arr[i])
			min = l;
		else
			min = i;

		if (r < arr.length && arr[min] > arr[r])
			min = r;

		if (min != i) {
			//exchange A[i] with A[min]
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
			minHeapify (arr, min);
		}
	}

	public static void main (String[] args) {
		int[] arr = {4,5,3,10,9,7};

		//build max heap
		for (int i = arr.length/2; i >= 0; i--)
			maxHeapify(arr, arr.length, i);
		
		//heap-sort
		for (int i = arr.length-1; i >= 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			
			maxHeapify (arr, i, 0);
		}
		
		System.out.println(java.util.Arrays.toString(arr));
	}
}