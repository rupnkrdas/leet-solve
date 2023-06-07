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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return dfs(root, subRoot);
    }

    public boolean dfs(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) return true;
        if (root == null) return false;

        if (isSame(root, subRoot)) return true;

        boolean left = dfs(root.left, subRoot);
        boolean right = dfs(root.right, subRoot);

        return left || right;
    }

    public boolean isSame(TreeNode p, TreeNode q) {
        if (p == null || q == null) return p == q;

        boolean isLeftSame = isSame(p.left, q.left);
        boolean isRightSame = isSame(p.right, q.right);

        return (p.val == q.val) && isLeftSame && isRightSame;
    }
}