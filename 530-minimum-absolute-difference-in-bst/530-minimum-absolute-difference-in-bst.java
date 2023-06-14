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
    long mini = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        inorder(root, new TreeNode[]{null});
        return (int)mini;
    }

    public void inorder(TreeNode node, TreeNode[] prev) {
        if (node == null) return;

        
        inorder(node.left, prev);
        
        if (prev[0] != null) {
            mini = Math.min(mini, (long)(node.val) - (long)(prev[0].val));
        }
        prev[0] = node;
        
        inorder(node.right, prev);
    }
}