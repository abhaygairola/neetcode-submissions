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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode groupPrev = dummy;
        ListNode groupNext = dummy;
        while (1 == 1) {
            ListNode kth = getkthNode(groupPrev, k);
            if (kth == null)
                break;
            groupNext = kth.next;

            ListNode prev = groupNext;
            ListNode cur = groupPrev.next;
            while (cur != groupNext) {
                ListNode temp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = temp;
            }
            ListNode temp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = temp;

        }
        return dummy.next;
    }
    private ListNode getkthNode(ListNode cur, int k) {
        ListNode head = cur;
        while (head != null && k > 0) {
            head = head.next;
            k--;
        }
        return head;
    }
}
