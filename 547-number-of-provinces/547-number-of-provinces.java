class DS {
    int[] parent;
    int[] size;

    public DS(int n) {
        parent = new int[n + 1];
        size = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int node) {
        if (node == parent[node])
            return node;
        return parent[node] = find(parent[node]);
    }

    public void union(int u, int v) {
        int uu = find(u);
        int uv = find(v);

        if (size[uu] < size[uv]) {
            parent[uu] = uv;
            size[uv] += size[uu];
        } else {
            parent[uv] = uu;
            size[uu] += size[uv];
        }
    }
}
class Solution {
    public int findCircleNum(int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges.length; j++) {
                if (i != j && edges[i][j] == 1) {
                    adj.get(i).add(j);
                }
            }
        }

        DS ds = new DS(adj.size());
        for (int i = 0; i < adj.size(); i++) {
            for (int v : adj.get(i)) {
                ds.union(i, v);
            }
        }

        int count = 0;
        for (int i = 0; i < adj.size(); i++) {
            if (ds.find(i) == i)
                count++;
        }

        return count;
    }
}