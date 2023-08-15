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
    public ListNode partition(ListNode head, int x) {
        ListNode l1 = new ListNode(-1);
        ListNode curr1 = l1;
        ListNode l2 = new ListNode(-1);
        ListNode curr2 = l2;

        ListNode curr = head;
        while (curr != null) {
            if (curr.val < x) {
                curr1.next = new ListNode(curr.val);
                curr1 = curr1.next;
            } else {
                curr2.next = new ListNode(curr.val);
                curr2 = curr2.next;
            }

            curr = curr.next;
        }

        curr1.next = l2.next;
        return l1.next;
    }
}