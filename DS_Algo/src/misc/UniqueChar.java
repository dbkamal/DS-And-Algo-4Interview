package misc;

public class UniqueChar {
	
	static boolean isUniqChar(String str) {
		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			System.out.println("val " + val);
			System.out.println("bool " + (checker & (1 << val)));
			
			if ((checker & (1 << val)) > 0)
				return false;

			checker |= (1 << val);
			System.out.println(checker);
		}
		return true;
	}
	
	static boolean isUniqueChar(String str) {
		boolean[] visited = new boolean[26];
		
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if (visited[val])
				return false;
			else
				visited[val] = true;
		}
		return true;
	}
}
