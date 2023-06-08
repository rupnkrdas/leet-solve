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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return dfs(root1, root2);
    }

    public TreeNode dfs(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            if (p == null && q == null) {
                return null;
            } else {
                return (p == null) ? q : p;
            }
        }
        
        
        TreeNode node = new TreeNode(p.val + q.val);
        node.left = dfs(p.left, q.left);;
        node.right = dfs(p.right, q.right);

        return node;
    }
}