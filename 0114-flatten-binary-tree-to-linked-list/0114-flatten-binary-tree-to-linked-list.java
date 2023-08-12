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
    private TreeNode f(TreeNode node) {
        if (node == null || (node.left == null && node.right == null)) {
            return node;
        }
        if (node.left == null) {
            TreeNode right = f(node.right);
            node.right = right;
            return node;
        }
        if (node.right == null) {
            TreeNode left = f(node.left);
            node.right = left;
            node.left = null;
            return node;
        }

        TreeNode node_ = node;
        TreeNode left = f(node.left);
        TreeNode right = f(node.right);

        node_.right = left;
        TreeNode curr = left;
        while (curr.right != null) {
            curr = curr.right;
        }
        curr.right = right;

        node_.left = null;
        return node_;
    }
    public void flatten(TreeNode root) {
        f(root);
    }
}