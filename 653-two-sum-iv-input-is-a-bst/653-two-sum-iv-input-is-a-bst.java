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
    public boolean findTarget(TreeNode root, int k) {
        return solve(root, k, new HashMap<>());
    }

    public boolean solve(TreeNode node, int target, Map<Integer, Boolean> map) {
        if (node == null) return false;

        if (map.containsKey(target - node.val)) return true;
        else map.put(node.val, true);
        return solve(node.left, target, map) || solve(node.right, target, map);
    }
}