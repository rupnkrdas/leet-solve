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
    public int minDepth(TreeNode root) {
        return solve(root);
    }

    public int solve(TreeNode node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;

        int left_min_height     = (int)1e9;
        if (node.left != null) {
            left_min_height = solve(node.left);
        }
        int right_min_height    = (int)1e9;
        if (node.right != null) {
            right_min_height = solve(node.right);
        }

        return 1 + Math.min(left_min_height, right_min_height);
    }
}