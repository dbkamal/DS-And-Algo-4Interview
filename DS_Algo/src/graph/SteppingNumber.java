package graph;

import java.util.*;

public class SteppingNumber {

	void steppingNumber (int n, int m) {

		LinkedList<Integer> queue = new LinkedList<Integer> ();
		int num1 = 0;
		int num2 = 0;

		for (int i = 0; i < 10; i++)
			queue.add(i);

		while (queue.size() > 0) {
			int p = queue.poll();

			if (p == 0 && p >= n && p <= m) {
				System.out.println(p);
				continue;
			}
			else if (p != 0) {
				if (p >= n && p <= m) {
					System.out.println(p);
				}
				
				if (p % 10 == 0) {
					num1 = p*10 + 1;
				}
				else if (p % 10 == 9) {
					num1 = p*10 + 8;
				}
				else {
					num1 = p*10 + (p % 10) - 1;
					num2 = p*10 + (p % 10) + 1;	
				}
				
				if (num1 >= n && num1 <= m && !queue.contains(num1))
					queue.add(num1);
				if (num2 >= n && num2 <= m && !queue.contains(num2))
					queue.add(num2);
			}
		}

	}

}