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
    private int get_left_nodes(TreeNode node) {
        if (node == null) return 0;

        int left_nodes = get_left_nodes(node.left);
        return left_nodes + 1;
    }
    private int get_right_nodes(TreeNode node) {
        if (node == null) return 0;

        int right_nodes = get_right_nodes(node.right);
        return right_nodes + 1;
    }
    
    private int count(TreeNode node) {
        if (node == null) return 0;

        int left_nodes  = get_left_nodes(node.left);
        int right_nodes = get_right_nodes(node.right);

        if (left_nodes == right_nodes) {
            int height = 1 + left_nodes;
            return (int)(Math.pow(2, height)) - 1;
        } else {
            return count(node.left) + count(node.right) + 1;
        }
    }
    
    public int countNodes(TreeNode root) {
        return count(root);
    }
}