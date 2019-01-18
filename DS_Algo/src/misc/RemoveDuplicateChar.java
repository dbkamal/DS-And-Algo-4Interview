package misc;

public class RemoveDuplicateChar {
	public static char[] removeDuplicateChar (char[] word) {
		int checker = 0;

		for (int i = 0; i < word.length; i++) {
			int val = word[i] - 'a';

			if ((checker & (1 << val)) > 0)
				word[i] = '\0';
			
			checker |= 1 << val;
		}
		return word;
	}
}