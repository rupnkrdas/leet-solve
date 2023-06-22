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
    Map<TreeNode, Map<Integer, Integer>> map = new HashMap<>();
    public int rob(TreeNode root ) {
        return Math.max(f(root, 0), f(root, 1));
    }

    public int f(TreeNode node, int canTake) {
        if (node == null) return 0;

        if (map.containsKey(node) && map.get(node).containsKey(canTake)) {
            return map.get(node).get(canTake);
        }

        int val = 0;
        if (canTake == 1) {
            val = Math.max(val, node.val + f(node.left, 0) + f(node.right, 0));
        } 
        val = Math.max(val, f(node.left, 1) + f(node.right, 1));

        if (!map.containsKey(node)) {
            map.put(node, new HashMap<>());
            map.get(node).put(canTake, val);
        } else {
            map.get(node).put(canTake, val);
        }
        return val;
    }
}