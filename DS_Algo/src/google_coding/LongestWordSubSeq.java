package google_coding;

/*
 * Ref: https://www.geeksforgeeks.org/find-largest-word-dictionary-deleting-characters-given-string/
 */

public class LongestWordSubSeq {
	
	static boolean isSubSeq (String str1, String str2) {
		int m = str1.length();
		int n = str2.length();
		int j = 0;
		
		for (int i = 0; i < m && j < n; i++) {
			if (str1.charAt(i) == str2.charAt(j))
				j++;
		}
		return (j == n);
	}

	static String longestWordSubSeq(String str, String[] words) {
		String result = "";
		int length = 0;
		
		for (String word : words) {
			if (length < word.length() && isSubSeq(str, word)) {
				result = word;
				length = word.length();
			}
		}
		
		return result;
	}
}
