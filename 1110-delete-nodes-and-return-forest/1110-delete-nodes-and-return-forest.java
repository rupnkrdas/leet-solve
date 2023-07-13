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
    private TreeNode delete_nodes(TreeNode node, Set<Integer> to_delete, List<TreeNode> remaining) {
        if (node == null) return null;

        node.left = delete_nodes(node.left, to_delete, remaining);
        node.right = delete_nodes(node.right, to_delete, remaining);

        if (to_delete.contains(node.val)) {
            if (node.left != null) {
                remaining.add(node.left);
            }
            if (node.right != null) {
                remaining.add(node.right);
            }

            return null;
        }

        return node;
    }
    public List<TreeNode> delNodes(TreeNode root, int[] toDelete) {
        Set<Integer> to_delete = new HashSet<>();
        for (int node : toDelete) {
            to_delete.add(node);
        }
        List<TreeNode> remaining = new ArrayList<>();

        delete_nodes(root, to_delete, remaining);
        if (!to_delete.contains(root.val)) {
            remaining.add(root);
        }
        return remaining;
    }
}