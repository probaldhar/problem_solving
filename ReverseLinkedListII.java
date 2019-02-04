package projects;

/**
 * 
 * Leetcode link: https://leetcode.com/problems/reverse-linked-list-ii/
 * 
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ReverseLinkedListII {
	
		public class ListNode {
			int val;
		    ListNode next;
		    ListNode(int x) { val = x; }
		}
		
    public ListNode reverseBetween(ListNode head, int m, int n) {
        
        if ( head == null && n == m ) {
            return head;
        }
        
        // set dummy point to head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        
        // previous node of the start of the reverse
        for ( int i = 0; i < m - 1; i++ ) {
            pre = pre.next;
        }
        
        // point to the end of the reverse
        ListNode tail = pre.next;
        
        /**
            interchange nodes
            Steps:
            1. set tmp to the first node in the reverse range (always)
            2. set the next node of previous node to the next node of the tail node
            3. set tail's next node to the following node of tail's next
            4. set the previous node's next next node to tmp
            !!
        */
        for ( int i = 0; i < n - m; i++ ) {
            ListNode tmp = pre.next;
            pre.next = tail.next;
            tail.next = tail.next.next;
            pre.next.next = tmp;
        }
        
        return dummy.next;
    }
}



