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
    private TreeNode f(int[] nums, int start, int end) {
        if (start>end) return null;
        if (start == end) return new TreeNode(nums[start]);

        TreeNode node = new TreeNode(nums[start]);
        int idx = -1;
        for (int i = start+1; i <= end; i++) {
            if (nums[i] > node.val) {
                idx = i;
                break;
            }
        }
        
        if (idx == -1) {
            node.right = null;
            node.left = f(nums, start+1, end);
        } else {
            node.left = f(nums, start+1, idx - 1);
            node.right = f(nums, idx, end);
        }

        return node;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;
        return f(preorder, 0, n - 1);
    }
}