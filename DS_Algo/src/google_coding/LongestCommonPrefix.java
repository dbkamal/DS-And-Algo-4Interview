package google_coding;

import java.util.*;

//ref: https://www.careercup.com/question?id=5740997808488448

public class LongestCommonPrefix {
/*
	public static void main (String[] args) {
		String s = "ababac";

		for (int i = 0; i < s.length(); i++) {
			String substr = s.substring(i, s.length());
			int count, k;
			count = k = 0;

			for (int j = 0; j < substr.length(); j++) {
				if (substr.charAt(j) != s.charAt(k))
					break;
				else {
					k++;
					count++;
				}
			}
			System.out.println(substr + " : " + count);
		}
	}
*/
	
	public static void main (String[] args) {
		String s = "ababac";
		String[] substr = new String[s.length()];

		for (int i = 0; i < s.length(); i++)
			substr[i] = s.substring(i);

		HashMap<String, Integer> map = new HashMap<String, Integer> ();

		// Create a grouping based on first prefix of the source character
		for (String word : substr) {
			if (word.charAt(0) == s.charAt(0))
				map.put(word, 1);
			else
				System.out.println(word + " : " + 0);
		}

		for (int i = 2; i <= s.length(); i++) {
			String str = s.substring(0, i);
		}
	}
}