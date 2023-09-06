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
    private void f(ListNode head, int inEachBucket, int rem, ListNode[] list) {
        ListNode curr = head, prev = null;
        for (int i = 0; i < list.length; i++) {
            list[i] = curr;
            for (int count = 0; count < inEachBucket + ((rem>0)?1:0); count++) {
                prev = curr;
                curr = curr.next;
            }
            if (prev != null) prev.next = null;
            rem--;
        }
    }
    private int getLength(ListNode head) {
        ListNode curr = head;
        int len = 0;
        while (curr != null) {
            len++;
            curr = curr.next;
        }

        return len;
    }
    public ListNode[] splitListToParts(ListNode head, int k) {
        int len = getLength(head);
        int inEachBucket = len/k;
        int rem = len%k;

        ListNode[] list = new ListNode[k];
        f(head, inEachBucket, rem, list);

        return list;
    }
}