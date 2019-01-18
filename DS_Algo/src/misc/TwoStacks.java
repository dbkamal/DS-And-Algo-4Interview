package misc;

public class TwoStacks {
	int[] arr;
	int top1;
	int top2;

	TwoStacks() {
		arr = new int[6];
		top1 = -1;
		top2 = arr.length;
	}

	//stack1
	void pushStack1(int data) {
		if (top1 < top2) {
			arr[++top1] = data;
		}
		else
			System.out.println("Stack overflow");
	}

	//stack2
	void pushStack2(int data) {
		if (top1 < top2) {
			arr[--top2] = data;
		}
		else
			System.out.println("Stack overflow");
	}

	//stack1
	int popStack1() {
		if (top1 < 0) {
			System.out.println("Stack underflow");
			return -1;
		}
		else
			return arr[top1--];
	}

	//stack2
	int popStack2() {
		if (top2 < arr.length+1) {
			System.out.println("Stack underflow");
			return -1;
		}
		else
			return arr[top2++];
	}
	
	void display() {
		System.out.println(java.util.Arrays.toString(arr));
	}
}