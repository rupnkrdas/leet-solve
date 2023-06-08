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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return solve(root, targetSum);
    }

    public boolean solve(TreeNode node, int sum) {
        if (node == null) return false;
        if (node.left == null && node.right == null && node.val == sum) return true;

        boolean left = solve(node.left, sum - node.val);
        boolean right = solve(node.right, sum - node.val);

        return left || right;
    }
}