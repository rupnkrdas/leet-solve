class DS {
    int[] size;
    int[] parent;

    public DS(int n) {
        size = new int[n + 1];
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            size[i] = 1;
            parent[i] = i;
        }
    }

    public int find(int node) {
        if (node == parent[node]) return node;
        return parent[node] = find(parent[node]);
    }

    public void union(int u, int v) {
        int uu = find(u);
        int uv = find(v);

        if (uu == uv) return;

        if (size[uu] > size[uv]) {
            parent[uv] = uu;
            size[uu] += size[uv];
        } else {
            parent[uu] = uv;
            size[uv] += size[uu];
        }
    }
}
class Solution {
    public long countPairs(int n, int[][] edges) {
        DS ds = new DS(n);
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];

            ds.union(u, v);
        }

        List<Integer> sizes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (ds.find(i) == i) {
                sizes.add(ds.size[i]);
            }
        }

        long ans = 0;
        int nodes_already_calculated = 0;
        for (int i = 0; i < sizes.size(); i++) {
            ans += (long)(sizes.get(i)) * (long)(n-nodes_already_calculated-sizes.get(i));
            nodes_already_calculated += sizes.get(i);
        }

        return ans;
    }
}