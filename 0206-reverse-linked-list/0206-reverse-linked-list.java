/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode dummy=null;

        while(head!=null){
            ListNode nextNodesAfterHead=head.next;
            head.next=dummy;
            dummy=head;
            head=nextNodesAfterHead;
        }

        return dummy;
    }
}