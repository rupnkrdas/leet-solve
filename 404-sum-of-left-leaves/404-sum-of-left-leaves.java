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
    public int sumOfLeftLeaves(TreeNode root) {
        return solve(root);
    }

    public int solve(TreeNode node) {
        // base-condition
        if (node == null) return 0;

        int sum = 0;
        if (node.left != null) {
            TreeNode leftNode = node.left;
            if (leftNode.left == null && leftNode.right == null) {
                sum += leftNode.val;
            }
        }
        sum += solve(node.left);
        sum += solve(node.right);

        return sum;
    }
}