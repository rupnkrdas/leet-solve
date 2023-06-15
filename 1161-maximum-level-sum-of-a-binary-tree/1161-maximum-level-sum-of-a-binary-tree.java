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
    Map<Integer, Integer> map = new TreeMap<>(); // level -> sum
    public int maxLevelSum(TreeNode root) {
        int maxSumLevel = -1;
        int sum = Integer.MIN_VALUE;
        dfs(root, 1);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int level = entry.getKey();
            int levelSum = entry.getValue();
            if (levelSum > sum) {
                sum = levelSum;
                maxSumLevel = level;
            }
        }

        return maxSumLevel;
    }

    public void dfs(TreeNode node, int level) {
        if (node == null) {
            return;
        }

        map.put(level, map.getOrDefault(level, 0) + node.val);

        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }
}