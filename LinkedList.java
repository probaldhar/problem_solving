package projects;

public class LinkedList {
	
	class Node {
      int val;
      Node next = null;
      
      // constructor
      Node(int x) { 
    	  val = x; 
      }
      
      // add node to tail
      void addNode(Node head, int x) {
    	  Node temp = new Node(x);
    	  
    	  // go to end
    	  while(head.next != null)
    		  head = head.next;
    	  
    	  head.next = temp;
      }
      
      // delete a node from a linked list
      // linear search
      Node deleteNode(Node head, int d) {
    	  
    	  Node prev = head;
    	  
    	  if (prev.val == d)
    		  return head.next;
    	  
    	// go to end
    	  while(prev.next != null) {
    		  
    		  if (prev.next.val == d) {
    			  prev.next = prev.next.next;
    			  return head;
    		  }
    		  prev = prev.next;
    	  }
    	  
    	  return head;
      }
      
      // print full linked list
      void printList(Node head) 
      { 
          Node current = head; 
          while (current != null) 
          { 
              System.out.print(current.val+" "); 
              current = current.next; 
          } 
      }
      
	}

}
