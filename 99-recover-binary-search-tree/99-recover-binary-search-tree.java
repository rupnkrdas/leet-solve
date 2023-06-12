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
    TreeNode first, middle, last, prev;
    public void recoverTree(TreeNode root) {
        inorder(root);
        if (first != null && last != null) {
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        } else if (first != null && middle != null){
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
        return;
    }

    public void inorder(TreeNode node) {
        if (node == null) return;

        inorder(node.left);

        if (prev != null && node.val < prev.val) {
            if (first == null) {
                first = prev;
                middle = node;
            } else {
                last = node;
            }
        }

        prev = node;
        inorder(node.right);
    }
}