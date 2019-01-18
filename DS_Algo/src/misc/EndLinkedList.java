package misc;

public class EndLinkedList {

	Node head;

	EndLinkedList (int data) {
		head = new Node(data);
	}

	void addNode(int data) {
		Node p = head;

		while (p.next != null) {
			p = p.next;
		}
		p.next = new Node(data);
	}

	void lastNodeFromN (int n) {
		Node ptr1, ptr2;
		ptr1 = ptr2 = head;

		while (n > 1 && ptr2.next != null) {
			if (ptr2.next == null)
				System.out.println("no N node found before the end");

			ptr2 = ptr2.next;
			n--;
		}

		while (ptr2.next != null) {
			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
		}
		System.out.println(ptr1.data);
	}
	
	void sumOfTwoLists (Node head1, Node head2) {
		Node ptr1, ptr2;
		ptr1 = head1;
		ptr2 = head2;
		int carry = 0;
		EndLinkedList newNode = null;

		if (head1 == null && head2 == null)
			System.out.println(0);

		while (ptr1 != null || ptr2 != null) {
			if (ptr2 == null) {
				carry += ptr1.data;
				ptr1 = ptr1.next;
			}
			else if (ptr1 == null) {
				carry += ptr2.data;
				ptr2 = ptr2.next;
			}
			else {
				carry += ptr1.data + ptr2.data;
				if (newNode == null)
					newNode = new EndLinkedList(carry % 10);

				ptr1 = ptr1.next;
				ptr2 = ptr2.next;
			}

			newNode.addNode(carry % 10);
			carry = (carry / 10) > 0 ? 1 : 0;
		}
		
		Node temp = newNode.head;
		while (temp.next != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

}

class Node {
	int data;
	Node next;

	Node (int data) {
		this.data = data;
		next = null;
	}
}