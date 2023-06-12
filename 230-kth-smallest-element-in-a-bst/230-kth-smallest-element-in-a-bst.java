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
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        return f(root, k).val;
    }

    public TreeNode f(TreeNode node, int k) {
        if (node == null) return null;

        TreeNode left = f(node.left, k);
        count++;
        if (count == k) return node;
        TreeNode right = f(node.right, k);

        if (left != null || right != null) {
            return (left != null) ? left : right;
        } else {
            return null;
        }
    }
}