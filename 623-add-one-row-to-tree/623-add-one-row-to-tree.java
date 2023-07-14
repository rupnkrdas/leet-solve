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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode new_node = new TreeNode(val);
            new_node.left = root;
            return new_node;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                TreeNode node = q.poll();
                if (level == depth - 2) {
                    if (node.left != null) {
                        TreeNode new_node = new TreeNode(val);
                        new_node.left = node.left;
                        node.left = new_node;
                        q.offer(new_node);
                    } else if (node.left == null) {
                        TreeNode new_node = new TreeNode(val);
                        node.left = new_node;
                        new_node.left = null;
                    }
                    if (node.right != null) {
                        TreeNode new_node = new TreeNode(val);
                        new_node.right = node.right;
                        node.right = new_node;
                        q.offer(new_node);
                    } else if (node.right == null) {
                        TreeNode new_node = new TreeNode(val);
                        node.right = new_node;
                        new_node.right = null;
                    }
                } else {
                    if (node.left != null) {
                        q.offer(node.left);
                    }
                    if (node.right != null) {
                        q.offer(node.right);
                    }
                }
            }

            level++;
        }

        return root;
    }
}