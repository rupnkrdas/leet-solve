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
    public boolean isEvenOddTree(TreeNode root) {
        boolean isOdd = true;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int sz = q.size();

            int prevVal = (isOdd) ? -1 : Integer.MAX_VALUE;
            while (sz-- > 0) {
                TreeNode node = q.poll();
                boolean hereOdd = node.val % 2 != 0;
                if (hereOdd && !isOdd) return false;
                if (!hereOdd && isOdd) return false;
                if (isOdd && node.val <= prevVal) return false;
                if (!isOdd && node.val >= prevVal) return false;

                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
                prevVal = node.val;
            }

            isOdd = !isOdd;
        }

        return true;
    }
}