/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return find(root, p, q);
    }

    public TreeNode find(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null || node == p || node == q) return node;

        TreeNode left = find(node.left, p, q);
        TreeNode right = find(node.right, p, q);

        if (left != null && right != null) return node;
        else {
            return (left == null) ? right : left;
        }

    }
}