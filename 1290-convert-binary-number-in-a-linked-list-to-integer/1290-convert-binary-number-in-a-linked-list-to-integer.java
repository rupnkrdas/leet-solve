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
    public int getDecimalValue(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }

        int ans = 0;
        int index = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            ans += list.get(i) * (Math.pow(2, index));
            index++;
        }

        return ans;
    }
}