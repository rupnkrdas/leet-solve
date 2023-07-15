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
    int max_val = Integer.MIN_VALUE;
    private void f(TreeNode node, int mini, int maxi) {
        if (node == null) return;

        int op1 = Math.abs(node.val - mini);
        int op2 = Math.abs(node.val - maxi);
        max_val = Math.max(max_val, Math.max(op1, op2));

        f(node.left, Math.min(mini, node.val), Math.max(maxi, node.val));
        f(node.right, Math.min(mini, node.val), Math.max(maxi, node.val));
    }
    public int maxAncestorDiff(TreeNode root) {
        f(root.left, root.val, root.val);
        f(root.right, root.val, root.val);

        return max_val;
    }
}