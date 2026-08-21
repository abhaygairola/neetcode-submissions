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
    public boolean hasCycle(ListNode head) {
        ListNode cur = head;
        ListNode run = head;
        while (run != null && run.next != null) {
            cur = cur.next;
            run = run.next.next;
            if (cur == run) {
                return true;
            }
        }
        return false;
    }
}
