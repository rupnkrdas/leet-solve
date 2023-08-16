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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Map<String, Boolean> dp = new HashMap <>();
    private boolean f(int idx, TreeNode node, List<Integer> list) {
        if (idx == list.size()) return true;
        if (node == null) return false;

        String key = Integer.toString(idx) + "," + node.toString();
        if (dp.containsKey(key)) return dp.get(key);
        // System.out.println(dp);


        if (node.val == list.get(idx)) {
            if (f(idx + 1, node.left, list) || f(idx + 1, node.right, list) || f(0, node.left, list) || f(0, node.right, list)) {
                // dp.put(key, true);
                return true;
            }
        } else {
            boolean ans = f(0, node.left, list) || f(0, node.right, list);
            dp.put(key, ans);
            return ans;
        }

        dp.put(key, false);
        return false;
    }
    public boolean isSubPath(ListNode head, TreeNode root) {
        List<Integer> list = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }

        return f(0, root, list);
    }
}