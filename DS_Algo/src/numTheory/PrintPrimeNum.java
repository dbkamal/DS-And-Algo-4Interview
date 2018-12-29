package numTheory;

/*
 * https://www.geeksforgeeks.org/sieve-of-eratosthenes/
 * https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
 */
public class PrintPrimeNum {
	public static void main(String[] args) {
		int n = 9999;
		boolean[] prime = new boolean[n+1];
		
		for (int i = 0; i < prime.length; i++)
			prime[i] = false;
		
		prime[0] = true;
		prime[1] = true;
		
		for (int i = 0; i < Math.sqrt(n)+1; i++) {
			if (!prime[i]) {
				//mark true all element which is multiplier of i
				for (int j = i; j < n/i+1; j++) {
					prime[j*i] = true;
				}
			}
		}
		
		for (int i = 0; i < prime.length; i++) {
			if (!prime[i])
				System.out.println(i);
		}
	}
}
