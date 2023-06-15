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
        // remove nth node from last => remove length - n + 1th node from first
        n = findLength(head) - n; // index
        System.out.println(n);
        if (n == 0) return head.next;

        int index = 0;
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            if (index == n) {
                ListNode temp = curr.next;
                curr = curr.next;
                prev.next = temp;
            } else {
                prev = curr;
                curr = curr.next;
            }
            index++;
        }

        return head;
    }

    public int findLength(ListNode head) {
        int count = 0;
        ListNode curr = head;

        while (curr != null) {
            count++;
            curr = curr.next;
        }

        return count;
    }
}