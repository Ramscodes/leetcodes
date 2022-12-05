/*
 * Here we are taking fast and slow pointer concept.
 -> Fast pointer will go two steps forward and at the same time slow goes one step forward
 -> By the time fast pointer reaches end the slow pointer will stay at the middle node
**/ 



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
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return fast.next!=null ? slow.next : slow;
    }
}