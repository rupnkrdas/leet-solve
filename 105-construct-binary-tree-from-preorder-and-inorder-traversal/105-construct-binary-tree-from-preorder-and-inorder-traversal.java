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
    Map<Integer, Integer> in_map = new HashMap<>(); // (num) -> (index)
    int[] pre;
    int[] in;
    private TreeNode f(int[] idx, int in_start, int in_end) {
        if (in_start > in_end) return null;
        
        int root_val = pre[idx[0]];
        TreeNode root = new TreeNode(root_val);
        int in_index = in_map.get(root_val);
        idx[0]++;
        
        root.left = f(idx, in_start, in_index - 1);
        root.right = f(idx, in_index + 1, in_end);
        
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        pre = preorder;
        in = inorder;
        for (int i = 0; i < n; i++) {
            in_map.put(inorder[i], i);
        }

        return f(new int[]{0}, 0, n - 1);
    }   
}