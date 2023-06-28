class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        char[] arr = labels.toCharArray();
        int[] ans = new int[labels.length()];

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] vis = new int[n];
        
        int[] letters = new int[26];
        solve(0, -1, adj, arr, ans, letters);

        return ans;
    }

    public void solve(int node, int parent, List<List<Integer>> adj, char[] arr, int[] ans, int[] letters) {
        int countBefore = letters[arr[node]-'a'];

        letters[arr[node]-'a']++;
        for (int adjNode : adj.get(node)) {
            if (adjNode != parent) {
                solve(adjNode, node, adj, arr, ans, letters);
            }
        }

        int countAfter = letters[arr[node]-'a'];
        ans[node] = (countAfter-countBefore);
    }
}