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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] maxi = {Integer.MIN_VALUE};
        dfs(root, maxi);

        return maxi[0] - 1;
    }

    public int dfs(TreeNode node, int[] maxi) {
        if (node == null) return 0;

        int left = dfs(node.left, maxi);
        int right = dfs(node.right, maxi);

        maxi[0] = Math.max(1 + left + right, maxi[0]);
        
        int passedValue = 1 + Math.max(left, right);
        return passedValue;
    }
}