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
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValid(TreeNode node, long mini, long maxi) {
        // base-case
        if (node == null) return true;

        // hypothesis
        boolean isLeftValid = isValid(node.left, mini, node.val);
        boolean isRightValid = isValid(node.right, node.val, maxi);

        // induction
        return (node.val > mini && node.val < maxi) && isLeftValid && isRightValid;
    }
}