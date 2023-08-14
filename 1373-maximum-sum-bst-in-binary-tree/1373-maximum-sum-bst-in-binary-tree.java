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
    int maxi = 0;
    private int[] f(TreeNode node) {
        if (node == null) {
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0, 1};
        }

        int[] left = f(node.left);
        int[] right = f(node.right);

        boolean isBST = false;
        if (left[1] < node.val && node.val < right[0] && left[3] == 1 && right[3] == 1) {
            isBST = true;
            maxi = Math.max(maxi, node.val + left[2] + right[2]);
        }

        int maxEl = Math.max(node.val, Math.max(left[1], right[1]));
        int minEl = Math.min(node.val, Math.min(left[0], right[0]));
        return (isBST)?new int[]{minEl, maxEl, node.val + left[2] + right[2], 1}: new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0, 0};
    }
    public int maxSumBST(TreeNode root) {
        f(root);
        return maxi;
    }
}