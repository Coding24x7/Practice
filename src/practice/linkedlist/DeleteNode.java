package practice.linkedlist;

public class DeleteNode {
	class Node {
		int data;
		Node next;
		
		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	Node head;
	Node last;

	public Node add(int data) {
		Node n = new Node(data);
		if (last == null) {
			head = n;
			last = n;
		} else {
			last.next = n;
			last = n;
		}
		return n;
	}

	public void print() {
		if (head == null) return;
	
		Node tmp = head;
		while(tmp.next != null) {
			System.out.print(tmp.data);
			System.out.print("-->");
			tmp = tmp.next;
		}
		System.out.print(tmp.data);
		System.out.println("");
	}

	public void delete(Node n) {
		if (n == null) return;
	
		if (n.next == null) {
			n = null;
			return;
		}

		n.data = n.next.data;
		n.next = n.next.next;
	}

	public static void main(String args[]) {
		DeleteNode dn = new DeleteNode();
		dn.add(1);
		dn.add(2);
		dn.add(3);
		dn.add(4);
		dn.print();
		dn.print();
		Node n = dn.add(5);
//		dn.add(1);
		dn.print();
		dn.delete(n);
		dn.print();
	}
}
