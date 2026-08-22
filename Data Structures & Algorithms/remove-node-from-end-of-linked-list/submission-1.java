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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int i = n;
        ListNode first = head;
        while (i>1) {
            first = first.next;
            i--;
        }

        ListNode second = head;
        ListNode prev = null;

        while (first.next != null) {
            first = first.next;
            prev = second;
            second = second.next;
        }
        if (prev == null ) return head.next;
       prev.next = second.next;

        return head;
    }
}
