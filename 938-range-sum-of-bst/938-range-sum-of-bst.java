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
    public int rangeSumBST(TreeNode root, int low, int high) {
        return solve(root, low, high);
    }

    public int solve(TreeNode node, int low, int high) {
        if(node == null) return 0;

        int left = solve(node.left, low, high);
        int right = solve(node.right, low, high);

        return (node.val >= low && node.val <= high) ? node.val + left + right : left + right;
    }
}