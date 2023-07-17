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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        ListNode i = reverse(l1);
        ListNode j = reverse(l2);

        int carry = 0;
        while (i != null || j != null || carry != 0) {
            int digit_i = (i != null) ? i.val : 0;
            int digit_j = (j != null) ? j.val : 0;
            
            int sum = digit_i + digit_j + carry;
            ListNode new_node = new ListNode(sum % 10);
            tail.next = new_node;
            tail = new_node;

            carry = sum / 10;
            i = (i != null) ? i.next : i;
            j = (j != null) ? j.next : j;
        }

        ListNode reversed_ans = dummy.next;
        return reverse(reversed_ans);
    }

    private ListNode reverse (ListNode head) {
        ListNode prev = null, curr = head;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}