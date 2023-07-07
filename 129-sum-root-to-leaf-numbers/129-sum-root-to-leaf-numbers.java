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
    List<Integer> list = new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        solve(root, 0);
        int sum = 0;

        for (int num : list) {
            sum += num;
        }

        return sum;
    }

    public void solve(TreeNode node, int num) {
        if (node != null && node.left == null && node.right == null) {
            list.add(num*10 + node.val);
            return;
        }

        if (node.left != null) {
            solve(node.left, num * 10 + node.val);
        }
        if (node.right != null) {
            solve(node.right, num * 10 + node.val);
        }
    }
}