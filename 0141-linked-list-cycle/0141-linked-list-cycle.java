/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
	
		// if head is NULL then return false;
        if(head == null)
            return false;
        
		// making two pointers fast and slow and assignning them to head
        ListNode fast = head;
        ListNode slow = head;
        
		// till fast and fast-> next not reaches NULL
		// we will increment fast by 2 step and slow by 1 step
        while(fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
            
			
			// At the point if fast and slow are at same address
			// this means linked list has a cycle in it.
            if(fast == slow)
                return true;
        }
        
		// if traversal reaches to NULL this means no cycle.
        return false;
    }
}