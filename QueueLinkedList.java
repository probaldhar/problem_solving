package projects;

public class QueueLinkedList {

	// linkedList Node
	class Node {
		private int val;
		private Node next;
		
		public Node(int data) {
			this.val = data;
			this.next = null;
		}
	}
	
	// front and rear of queue
	private Node front;
	private Node rear;
	
	// push to rear
	public void push(int data) {
		Node temp = new Node(data);
		
		// first element
		// push to rear
		if (rear != null)
			rear.next = temp;
		
		rear = temp;
		
		// first element
		if (isEmpty())
			front = null;
	}
	
	// pop from front
	public int pop() {
		if (isEmpty()) {
			System.out.println("No element in the front");
			return -1;
		}
		
		int data = front.val;
		// remove element
		front = front.next;
		
		// empty
		if (isEmpty())
			rear = null;
		
		return data;
	}
	
	// check if empty queue
	public boolean isEmpty() {
		return front == null;
	}
	
}



