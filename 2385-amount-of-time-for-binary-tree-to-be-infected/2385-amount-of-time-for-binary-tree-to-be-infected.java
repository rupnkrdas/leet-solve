/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    private void markParents(TreeNode node, Map<TreeNode, TreeNode> map) {
        if (node == null)
            return;

        if (node.left != null) {
            map.put(node.left, node);
        }
        if (node.right != null) {
            map.put(node.right, node);
        }

        markParents(node.left, map);
        markParents(node.right, map);
    }

    private TreeNode getNode(TreeNode node, int start) {
        if (node == null)
            return null;

        if (node.val == start)
            return node;

        TreeNode left = getNode(node.left, start);
        return (left != null) ? left : getNode(node.right, start);
    }

    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        markParents(root, map);

        Queue<TreeNode> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        
        TreeNode startingNode = getNode(root, start);
        q.offer(startingNode);
        set.add(startingNode.val);

        int time = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                TreeNode node = q.poll();

                if (node.left != null && !set.contains(node.left.val)) {
                    q.offer(node.left);
                    set.add(node.left.val);
                }
                if (node.right != null && !set.contains(node.right.val)) {
                    q.offer(node.right);
                    set.add(node.right.val);
                }
                if (map.containsKey(node) && !set.contains(map.get(node).val)) {
                    q.offer(map.get(node));
                    set.add(map.get(node).val);
                }
            }

            time++;
        }

        return time - 1;
    }
}