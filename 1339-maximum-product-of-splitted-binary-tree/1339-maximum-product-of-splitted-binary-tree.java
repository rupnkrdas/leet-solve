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
    private long MOD = (long)(1e9 + 7);
    long maxi = Long.MIN_VALUE;
    long total_sum = 0;

    private long get_sum(TreeNode node) {
        if (node == null) return 0;

        long left_sum = get_sum(node.left);
        long right_sum = get_sum(node.right);
        long op1 = left_sum * (total_sum - left_sum);
        long op2 = right_sum * (total_sum - right_sum);

        maxi = Math.max(maxi, Math.max(op1, op2));
        return (long)node.val + left_sum + right_sum;
    }

    public int maxProduct(TreeNode root) {
        total_sum = get_sum(root);
        
        // System.out.println(total_sum);

        get_sum(root);

        return (int)(maxi % MOD);
    }
}