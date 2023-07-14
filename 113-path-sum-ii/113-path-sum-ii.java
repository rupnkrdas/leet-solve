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
    List<List<Integer>> ans = new ArrayList<>();
    private void f(TreeNode node, int target_sum, List<Integer> list) {
        if (node == null) return;
        if (node != null && node.left == null && node.right == null && node.val == target_sum) {
            list.add(node.val);
            ans.add(new ArrayList<>(list));
            list.remove(list.size() - 1);

            return;
        }

        list.add(node.val);
        f(node.left, target_sum - node.val, list);
        list.remove(list.size() - 1);
        list.add(node.val);
        f(node.right, target_sum - node.val, list);
        list.remove(list.size() - 1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        f(root, targetSum, new ArrayList<>());
        return ans;
    }
}