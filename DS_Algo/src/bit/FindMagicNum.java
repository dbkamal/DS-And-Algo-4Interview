package bit;

public class FindMagicNum {
	public static void main (String[] args) {
		int n = 5;
		int pow, answer;
		pow = 1;
		answer = 0;
		
		while (n > 0) {
			pow = pow * 5;
			
			if ((n & 1) == 1)
				answer += pow;
			
			n = n >> 1;
		}
		
		System.out.println(answer);
	}
}
