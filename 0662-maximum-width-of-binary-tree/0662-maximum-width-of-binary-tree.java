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
class Pair {
    TreeNode first;
    int second;

    public Pair(TreeNode first, int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "[" + first.val + ", " + second + "]";
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Deque<Pair> dq = new LinkedList<>();
        dq.offer(new Pair(root, 0));
        int maxWidth = 0;
        while (!dq.isEmpty()) {
            int size = dq.size();
            int left = dq.getFirst().second;
            int right = dq.getLast().second;
            maxWidth = Math.max(maxWidth, right - left + 1);

            while (size-- > 0) {
                Pair p = dq.poll();
                TreeNode node = p.first;
                int idx = p.second;

                if (node.left != null) {
                    dq.offer(new Pair(node.left, 2*idx + 1));
                }
                if (node.right != null) {
                    dq.offer(new Pair(node.right, 2*idx + 2));
                }
            }
        }

        return maxWidth;
    }
}