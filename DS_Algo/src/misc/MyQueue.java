package misc;

import java.util.*;

public class MyQueue {
	Stack<Integer> s1;
	Stack<Integer> s2;

	MyQueue() {
		s1 = new Stack<Integer> ();
		s2 = new Stack<Integer> ();
	}

	void enqueue(int data) {
		s1.push(data);
	}

	int dequeue() {
		if (s1.size() == 0 && s2.size() == 0)
			return -1;

		// pop element from stack1 to stack2
		if (s2.size() == 0) {
			while (s1.size() > 0)
				s2.push(s1.pop());
		}

		return s2.pop();
	}
}