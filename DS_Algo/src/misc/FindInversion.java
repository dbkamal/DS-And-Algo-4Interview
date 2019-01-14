package misc;

public class FindInversion {

	static int merge (int[] arr, int[] temp, int low, int mid, int high) {
		int i, j, k;
		i = low;
		j = mid+1;
		k = 0;
		int count = 0;

		while (i <= mid && j <= high) {
			if (arr[i] > arr[j]) {
				temp[k++] = arr[j];
				j++;
				count = count + (mid - i + 1);
			}
			else if (arr[i] < arr[j]) {
				temp[k++] = arr[i];
				i++;
			}
		}

		while (i <= mid)
			temp[k++] = arr[i++];

		while (j <= high)
			temp[k++] = arr[j++];

		k = 0;
		for (i = low; i <= high && k < temp.length; i++)
			arr[i] = temp[k++];
		
		return count;
	}

	static int divide (int[] arr, int[] temp, int low, int high) {
		int mid, count;
		count = 0;

		if (low < high) {
			mid = (low + high) / 2;
			count = divide (arr, temp, low, mid);
			count += divide (arr, temp, mid+1, high);
			count += merge (arr, temp, low, mid, high);
		}
		return count;
	}

	static int findInversion (int[] arr, int[] temp) {
		return divide (arr, temp, 0, arr.length-1);
	}
	
	public static void main (String[] args) {
		int[] arr = {2,4,1,3,6,5};
		int[] temp = new int[arr.length];
		System.out.println(findInversion(arr, temp));
		System.out.println(java.util.Arrays.toString(arr));
	}
}