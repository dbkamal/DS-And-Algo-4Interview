package misc;

public class SegmentTree {

	static int[] in;

	static int getMid (int l, int r) {
		return l + (r - l) / 2;
	}

	static int buildSegmentTree (int[] arr, int l, int r, int i) {
		if (l == r) {
			in[i] = arr[l];
			return arr[l];
		}

		int mid = getMid (l, r);
		in[i] = buildSegmentTree (arr, l, mid, i*2 + 1) +
		        buildSegmentTree (arr, mid+1, r, i*2 + 2);
		return in[i];
	}

	static int getSumUtil (int s, int d, int l, int r, int i) {
		if (l <= s && d <= r)
			return in[i];

		if (s > r || d < l)
			return 0;

		int mid = getMid (s, d);
		return getSumUtil (s, mid, l, r, 2*i + 1) +
					getSumUtil (mid+1, d, l, r, 2*i + 2);
	}

	static int getSum (int n, int l, int r) {
		return getSumUtil (0, n-1, l, r, 0);
	}

	public static void main (String[] args) {
		int[] arr = {1,3,5,7,9,11};
		int height = (int) (Math.ceil(Math.log(arr.length) / Math.log(2)));
		int max_size = 2 * (int) Math.pow(2, height) - 1;
		in = new int[max_size];
		buildSegmentTree (arr, 0, arr.length-1, 0);
		System.out.println(java.util.Arrays.toString(in));

		System.out.println(getSum (arr.length, 2, 4));
	}
}