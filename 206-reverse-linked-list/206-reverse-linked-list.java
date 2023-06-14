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
        return solve(head);
    }

    public ListNode solve(ListNode head) {
        // base-case
        if (head == null || head.next == null) return head;

        // hypothesis
        ListNode reversedHead = solve(head.next);
        // get the tail of the newly reversed linkedlist
        ListNode node = reversedHead;
        while (node.next != null) node = node.next;
        // node points to the tail
        // attach the previous head
        node.next = head;
        head.next = null;

        return reversedHead;
    }
}