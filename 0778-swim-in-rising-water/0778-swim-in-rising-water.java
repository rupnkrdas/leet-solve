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
    int[] delI = {-1, 0, 1, 0};
    int[] delJ = {0, 1, 0, -1};
    public boolean isSafe(int i, int j, int n, int m) {
        return (i >= 0 && i < n && j >= 0 && j < m);
    }
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        List<Integer> sorted = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int cell = n * i + j;
                sorted.add(cell);
            }
        }

        Collections.sort(sorted, (n1, n2) -> grid[n1/n][n1%n] - grid[n2/n][n2%n]);
        DS ds = new DS(n*n);

        for (int cell : sorted) {
            int i = cell/n;
            int j = cell%n;

            for (int k = 0; k < 4; k++) {
                int ni = i + delI[k];
                int nj = j + delJ[k];

                int cell_ = n * (ni) + nj;

                if (isSafe(ni, nj, n, n) && grid[ni][nj] < grid[i][j]) {
                    ds.union(cell_, cell);  
                }


                if (ds.find(0) == ds.find(n*n - 1)) return grid[i][j];
            }
        }

        return -1;
    }
}