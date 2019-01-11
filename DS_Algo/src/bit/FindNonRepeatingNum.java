package bit;

public class FindNonRepeatingNum {
	public static void main (String[] args) {
		int[] arr = {1, 2, 3, 2, 3, 1, 3};
		int val = 0;
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(Integer.toBinaryString(val));
			System.out.println();
			System.out.print(Integer.toBinaryString(arr[i]));
			val ^= arr[i];
		}
		
		System.out.println(val);
	}
}
