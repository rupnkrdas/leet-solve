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
    private List<TreeNode> f(int n) {
        if (n % 2 == 0) { // even
            return new ArrayList<>();
        }

        if (n == 1) {
            TreeNode node = new TreeNode(0);
            List<TreeNode> list = new ArrayList<>();
            list.add(node);
            return list;
        }
        

        List<TreeNode> list = new ArrayList<>();
        for (int i = 1; i < n; i += 2) {
            List<TreeNode> left = f(i);
            List<TreeNode> right = f(n - i - 1);

            for (TreeNode left_child : left) {
                for (TreeNode right_child : right) {
                    TreeNode root = new TreeNode(0);
                    root.left = left_child;
                    root.right = right_child;
                    list.add(root);
                }
            }
        }

        return list;
    }
    public List<TreeNode> allPossibleFBT(int n) {
        return f(n);
    }
}