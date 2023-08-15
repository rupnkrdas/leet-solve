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
    private ListNode merge(ListNode i, ListNode j) {
        if (i == null || j == null) {
            if (i == null && j == null) return null;
            return (i != null) ? i : j;
        }

        if (i.val < j.val) {
            ListNode sorted = merge(i.next, j);
            i.next = sorted;
            return i;
        } else {
            ListNode sorted = merge(i, j.next);
            j.next = sorted;
            return j;
        }
    }
    private ListNode f(int idx, ListNode[] lists) {
        if (idx == lists.length) return null;

        ListNode l = lists[idx];
        ListNode sorted = f(idx + 1, lists);

        ListNode merged = merge(l, sorted);
        return merged;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        return f(0, lists);
    }
}