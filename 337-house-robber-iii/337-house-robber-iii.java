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
    public int rob(TreeNode root) {
        int ans[] = solve(root);
        return Math.max(ans[0], ans[1]);
    }

    // solve() returns two values in an array, arr[0] = max if take this node, arr[1] = max if not take this node
    // this is our hypothesis
    public int[] solve(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }

        int[] left = solve(node.left);
        int[] right = solve(node.right);
        int[] ans = new int[2];

        ans[0] = node.val + left[1] + right[1];
        ans[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return ans;
    }
}