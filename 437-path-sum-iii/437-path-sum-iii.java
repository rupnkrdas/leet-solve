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
    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        solve(root, targetSum, 0, new HashMap<>());
        return count;
    }

    public void solve(TreeNode node, int target, long sum, Map<Long, Integer> map) {
        if (node == null) return;

        sum += node.val;
        if (sum == target) count++;
        if (map.containsKey(sum - target)) count += map.get(sum - target);
        
        map.put(sum, map.getOrDefault(sum, 0) + 1);

        solve(node.left, target, sum, map);
        solve(node.right, target, sum, map);
        
        map.put(sum, map.get(sum) - 1);
        if (map.get(sum) == 0) {
            map.remove(sum);
        }
    }
}