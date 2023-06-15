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
    public int maxLevelSum(TreeNode root) {
        if (root.left == null && root.right == null) return 1;
        Queue<TreeNode> q = new LinkedList<>();
        int level = 0;
        int maxLevel = 0;
        long maxi = Long.MIN_VALUE;

        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            level++;
            long sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                sum += (long)node.val;
                
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            if (sum > maxi) {
                maxi = sum;
                maxLevel = level;
            }
        }

        return maxLevel;
    }
}