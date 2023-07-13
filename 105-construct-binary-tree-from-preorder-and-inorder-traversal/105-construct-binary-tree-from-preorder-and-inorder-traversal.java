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
    private TreeNode f(int pre_start, int pre_end, int in_start, int in_end) {
        if (pre_start > pre_end || in_start > in_end) return null;
        
        TreeNode root = new TreeNode(pre[pre_start]);
        int in_index = in_map.get(root.val);
        int nums_left = in_index - in_start;
        
        root.left = f(pre_start + 1, pre_start + nums_left, in_start, in_index - 1);
        root.right = f(pre_start + nums_left + 1, pre_end, in_index + 1, in_end);
        
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        pre = preorder;
        in = inorder;
        for (int i = 0; i < n; i++) {
            in_map.put(inorder[i], i);
        }

        return f(0, n - 1, 0, n - 1);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}