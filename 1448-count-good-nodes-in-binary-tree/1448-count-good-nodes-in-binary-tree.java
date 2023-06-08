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
    int maxi = Integer.MIN_VALUE;
    int count = 0;
    public int goodNodes(TreeNode root) {
        solve(root);
        return count;
    }

    public void solve(TreeNode node) {
        if (node == null) return;

        if (node.val >= maxi) {
            count++;
            maxi = node.val;
        }

        int temp = maxi;
        
        solve(node.left);
        maxi = temp;
        solve(node.right);
    } 
}