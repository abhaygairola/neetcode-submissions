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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        List<ListNode> res = new ArrayList<>(Arrays.asList(lists));
        while (res.size() > 1) {
            List<ListNode> temp = new ArrayList<>();
            for (int i = 0; i < res.size(); i+=2) {
                ListNode l1 = res.get(i);
                ListNode l2 = (i + 1 == res.size()) ? null : res.get(i + 1);
                temp.add(mergeList(l1, l2));
            }
            res = temp;
        }
        return res.get(0);
    }

    private ListNode mergeList(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }

        if (list1 != null) {
            cur.next = list1;
        } else if (list2 != null) {
            cur.next = list2;
        }
        return dummy.next;
    }
}
