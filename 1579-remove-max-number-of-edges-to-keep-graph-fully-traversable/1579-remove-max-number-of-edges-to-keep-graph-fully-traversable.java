class DS {
    int[] size;
    int[] parent;

    public DS(int n) {
        this.size = new int[n + 1];
        this.parent = new int[n + 1];
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
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        Arrays.sort(edges, (e1, e2) -> e2[0] - e1[0]);

        DS dsAlice = new DS(n);
        DS dsBob = new DS(n);

        int count = 0;

        for (int[] e : edges) {
            int type = e[0];
            int u = e[1];
            int v = e[2];

            if (type == 3) {
                if (dsAlice.find(u) == dsAlice.find(v) && dsBob.find(u) == dsBob.find(v)) {
                    count++;
                    continue;
                }
                dsAlice.union(u, v);
                dsBob.union(u, v);
            } else if (type == 1) {
                if (dsAlice.find(u) == dsAlice.find(v)) count++;
                else dsAlice.union(u, v);
            } else {
                if (dsBob.find(u) == dsBob.find(v)) count++;
                else dsBob.union(u, v);
            }
        }

        int parent1 = dsAlice.find(1);
        int parent2 = dsBob.find(1);

        for (int node = 1; node <= n; node++) {
            if (dsAlice.find(node) != parent1) return -1;
            if (dsBob.find(node) != parent2) return -1;
        }

        return count;
    }
}