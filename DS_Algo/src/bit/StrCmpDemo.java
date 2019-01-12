package bit;

public class StrCmpDemo {

	public static void main(String[] args) {
		String s1 = "geeks";
		String s2 = "GeeKp";
		char[] ch1 = s1.toCharArray();
		char[] ch2 = s2.toCharArray();
		
		if (s1.length() != s2.length())
			System.out.println("not equal");
		else {
			for (int i = 0; i < ch1.length; i++) {
				if (ch1[i] == ch2[i])
					continue;
				else {
					if (ch1[i] >= 97 && ch2[i] < 97) {
						ch2[i] += 1 << 5;
					}
					
					if (ch2[i] > 97 && ch1[i] < 97) {
						ch1[i] += 1 << 5;
					}
					
					if (ch1[i] != ch2[i]) {
						System.out.println("not equal");
						return;
					}
				}
			}
		}
		
		System.out.println("equal");
	}
}
