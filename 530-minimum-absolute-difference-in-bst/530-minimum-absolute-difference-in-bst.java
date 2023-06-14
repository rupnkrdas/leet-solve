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
    List<Integer> list;
    public int getMinimumDifference(TreeNode root) {
        list = new ArrayList<>();
        inorder(root);
        int n = list.size();
        int mini = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            int diff = list.get(i+1) - list.get(i);
            mini = Math.min(mini, diff);
        }

        return mini;
    }

    public void inorder(TreeNode node) {
        if (node == null) return;

        inorder(node.left);
        list.add(node.val);
        inorder(node.right);
    }
}