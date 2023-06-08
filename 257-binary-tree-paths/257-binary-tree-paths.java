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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        solve(root, "", ans);
        return ans;
    }

    public void solve(TreeNode node, String s, List<String> ans) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            s += Integer.toString(node.val);
            ans.add(new String(s));
        }

        String temp = s;
        s += node.val + "->";

        solve(node.left, s, ans);

        solve(node.right, s, ans);
    }
}