/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Pair {
    TreeNode first;
    int second;

    public Pair(TreeNode first, int second) {
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public void fill(TreeNode root, Map<TreeNode, TreeNode> p_map) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    p_map.put(node.left, node);
                    q.offer(node.left);
                }
                if (node.right != null) {
                    p_map.put(node.right, node);
                    q.offer(node.right);
                }
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Set<TreeNode> set = new HashSet<>();
        Map<TreeNode, TreeNode> p_map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        fill(root, p_map);
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(target, 0));
        set.add(target);
        while(!q.isEmpty()) {
            Pair pair = q.poll();
            TreeNode node = pair.first;
            int distance = pair.second;
            if (distance == k)
                ans.add(node.val);
            if (distance > k) break;

            //parent
            if (p_map.containsKey(node)) {
                TreeNode parent = p_map.get(node);
                if (!set.contains(parent)) {
                    set.add(parent);
                    q.offer(new Pair(parent, distance + 1));
                }
            }
            //left
            if (node.left != null) {
                TreeNode left = node.left;
                if (!set.contains(left)) {
                    set.add(left);
                    q.offer(new Pair(left, distance + 1));
                }
            }
            //right
            if (node.right != null) {
                TreeNode right = node.right;
                if (!set.contains(right)) {
                    set.add(right);
                    q.offer(new Pair(right, distance + 1));
                }
            }
        }

        return ans;
    }
}