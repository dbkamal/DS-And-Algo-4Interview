package google_coding;

public class Test {

	static boolean isSubSeq (String msg, String str) {
		int i, j;
		i = j = 0;

		if (msg.length() > str.length())
			return false;
		if (msg.length() == 0)
			return false;

		while (i < str.length() && j < msg.length()) {
			if (msg.charAt(j) == str.charAt(i)) {
				i++;
				j++;
			}
			else if (msg.charAt(j) != str.charAt(i) && j < msg.length())
				i++;
		}

		if (i == str.length() && j < msg.length())
			return false;

		return true;
	}

	static String longestSubSeq(String str, String[] words) {
		int count = 0;
		String result = "";
		for (int i = 0; i < words.length; i++) {
			String msg = words[i];
			if (isSubSeq(msg, str) && count < msg.length()) {
				result = msg;
				count = msg.length();
			}
		}
		return result;
	}

	public static void main (String[] args) {
		String str = "abppplee";
		String[] words = {"able","ale","apple","bale","kangaroo"};

		System.out.println(longestSubSeq(str, words));
	}
}