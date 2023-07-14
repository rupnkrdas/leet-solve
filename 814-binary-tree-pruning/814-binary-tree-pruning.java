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
    private TreeNode remove(TreeNode node) {
        if (node == null) return null;
        if (node.left == null && node.right == null) {
            return (node.val == 1) ? node : null;
        }

        node.left   = remove(node.left);
        node.right  = remove(node.right);

        if (node.val == 0) {
            if (node.left == null && node.right == null) {
                return null;
            } else {
                return node;
            }
        } else {
            return node;
        }
    }
    public TreeNode pruneTree(TreeNode root) {
        return remove(root);
    }
}