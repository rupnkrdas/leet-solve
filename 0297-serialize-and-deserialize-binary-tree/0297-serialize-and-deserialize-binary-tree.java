/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    String res = "";
    String[] arr;
    int i = 0;
    // TreeNode node;

    private void dfs(TreeNode root) {
        if (root == null) {
            res += "null,";
            return;
        }
        res += Integer.toString(root.val) + ",";
        dfs(root.left);
        dfs(root.right);
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        dfs(root);
        return res;
    }

    private TreeNode dfs_() {
        if (arr[i].equals("null")) {
            i++;
            return null;
        }

        // System.out.println(arr[i]);
        TreeNode node = new TreeNode(Integer.parseInt(arr[i]));
        i++;
        node.left = dfs_();
        node.right = dfs_();

        return node;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        arr = data.split(",");
        // System.out.println(Arrays.toString(arr));

        return dfs_();
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));