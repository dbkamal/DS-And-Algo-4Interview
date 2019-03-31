package searching_and_sorting;

/** https://stackoverflow.com/questions/5610024/please-explain-to-me-the-solution-for-the-problem-below */
import java.util.*;

public class AddTwoBinary {
	public static int[] addTwoBinary(int[] a, int[] b) {
		if (a.length != b.length)
			return null;

		int[] c = new int[a.length + 1];
		Arrays.fill(c, 0);

		for(int i = a.length - 1; i >= 0; i--) {
			int sum = a[i] + b[i] + c[i + 1];
			/** store the sum into the current position and put carry into previous place */
			c[i + 1] = sum % 2;
			c[i] = sum / 2;
		}
		
		return c;
	}
}
