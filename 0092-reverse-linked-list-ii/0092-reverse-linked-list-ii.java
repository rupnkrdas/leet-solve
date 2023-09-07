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
    private ListNode[] reverse(ListNode head, int len) {
        ListNode curr = head, prev = null;
        while (curr != null && len-- > 0) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return new ListNode[]{prev, head};
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int len = right - left + 1;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = head, prev = dummy;
        for (int i = 1; i < left; i++) {
            prev = curr;
            curr = curr.next;
        }
        ListNode next = curr;
        for (int i = 0; i < len; i++) {
            next = next.next;
        }
        
        ListNode[] reversed = reverse(curr, len);
        prev.next = reversed[0];
        reversed[1].next = next;

        return dummy.next;
    }
}