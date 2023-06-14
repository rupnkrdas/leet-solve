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
        return solve(head, k);
    }

    public ListNode solve(ListNode head, int k) {
        if (findLength(head) < k) {
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;
        int count = 0;
        while (count < k && curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            count++;
        }

        // System.out.println(curr.val);
        // System.out.println(head.val);
        head.next = solve(curr, k);
        return prev;
    }

    public int findLength(ListNode head) {
        int count = 0;
        ListNode curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }

        // System.out.println(count);

        return count;
    }
}