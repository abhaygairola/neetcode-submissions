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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode h = slow.next;
        slow.next = null;
        ListNode prev = null;
        while (h != null) {
            ListNode temp = h.next;
            h.next = prev;
            prev = h;
            h = temp;
        }
        ListNode dummy = new ListNode();
        ListNode res = dummy;

        while (prev != null && head != null) {
            dummy.next = head;
            dummy = dummy.next;
            head = head.next;

            dummy.next = prev;
            dummy = dummy.next;
            prev = prev.next;
        }
        if (prev != null) {
            dummy.next = prev;
        }
        if (head != null) {
            dummy.next = head;
        }
    }
}
