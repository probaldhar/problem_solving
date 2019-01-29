package projects;

public class StackLinkedList {
	
	// linkedList Node
	class Node {
		private int val;
		private Node next;
		
		public Node(int data) {
			this.val = data;
			this.next = null;
		}
	}
	
	// top of stack
	private Node stackTop;
	
	// push an element to the top of stack
	public void push(int data) {
		// create a temp node
		Node temp = new Node(data);
		temp.next = stackTop;
		stackTop = temp;
	}
	
	// delete an element from the top of stack
	public int pop() {
		int item = stackTop.val;
		stackTop = stackTop.next;
		return item;
	}
	
	// check if the stack is empty
	public boolean isEmpty() {
		return stackTop == null;
	}

}
