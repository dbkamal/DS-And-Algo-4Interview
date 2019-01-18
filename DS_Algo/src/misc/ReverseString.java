package misc;

public class ReverseString {
	public static char[] reverseString (char[] word) {
		int i, j;
		i = 0;
		j = word.length-2;

		if (word.length == 0 || word.length == 1)
			return word;

		while (i < j) {
			char temp = word[i];
			word[i] = word[j];
			word[j] = temp;
			i++;
			j--;
		}

		return word;
	}
}