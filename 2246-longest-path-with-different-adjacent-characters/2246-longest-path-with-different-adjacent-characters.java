class Solution {
    public int longestPath(int[] parent, String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            int u = i;
            int v = parent[i];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] maxi = {0};
        solve(0, -1, adj, arr, maxi);

        return maxi[0];
    }

    public int solve(int node, int parent, List<List<Integer>> adj, char[] arr, int[] maxi) {
        int longest = 0;
        int second_longest = 0;

        for (int adjNode : adj.get(node)) {
            if (adjNode == parent) continue;
            int len_from_child = solve(adjNode, node, adj, arr, maxi);
            if (arr[adjNode] == arr[node]) continue;
            second_longest = Math.max(second_longest, len_from_child);
            if (second_longest > longest) {
                // swap
                int temp = second_longest;
                second_longest = longest;
                longest = temp;
            }
        }

        int koi_ek_acha = Math.max(longest, second_longest) + 1;
        int neeche_hi_mil_gya = 1 + longest + second_longest;
        int only_root_acha = 1;
        maxi[0] = Math.max(maxi[0], Math.max(koi_ek_acha, Math.max(neeche_hi_mil_gya, only_root_acha)));
        return Math.max(only_root_acha, koi_ek_acha);
    }
}