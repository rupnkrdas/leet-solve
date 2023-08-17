class DS {
    int[] size;
    int[] parent;
    int count;

    public DS(int n) {
        size = new int[n + 1];
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            size[i] = 1;
            parent[i] = i;
        }

        this.count = 1;
    }

    public int find(int node) {
        if (node == parent[node]) return node;
        return parent[node] = find(parent[node]);
    }

    public void union(int u, int v) {
        int uu = find(u);
        int uv = find(v);

        if (uu == uv) {
            count++;
            return;
        }

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
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int dots = n + 1;
        DS ds = new DS(dots*dots);

        for (int i = 0; i < dots; i++) {
            for (int j = 0; j < dots; j++) {
                if (i == 0 || j == 0 || i == dots-1 || j == dots-1) {
                    int node = dots*i + j;
                    if (node != 0) {
                        ds.union(0, node);
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            char[] arr = grid[i].toCharArray();
            for (int j = 0; j < n; j++) {
                if (arr[j] == '/') {
                    int node1 = (i)*dots + (j + 1);
                    int node2 = (i + 1)*dots + (j);

                    ds.union(node1, node2);
                } else if (arr[j] == '\\') {
                    int node1 = (i)*dots + (j);
                    int node2 = (i + 1)*dots + (j + 1);

                    ds.union(node1, node2);
                } else {
                    continue;
                }
            }
        }

        return ds.count;
    }
}