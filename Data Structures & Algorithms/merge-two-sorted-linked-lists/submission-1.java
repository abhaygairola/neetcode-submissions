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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode b = new ListNode();
        ListNode h1 = b;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                h1.next = list1;
                list1 = list1.next;
            } else {
                h1.next = list2;
                list2 = list2.next;
            }
            h1 = h1.next;
        }
        if (list1 != null) {
            h1.next = list1;
        } else if (list2 != null) {
            h1.next = list2;
        }
        return b.next;
    }
}