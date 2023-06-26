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
    private boolean isSafe(int i, int j, int n, int m) {
        return (i >= 0 && i < n && j >= 0 && j < m);
    }
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DS ds = new DS(n*n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int node = i*n + j;
                    for (int k = 0; k < 4; k++) {
                        int ni = i + delI[k];
                        int nj = j + delJ[k];
                        if (isSafe(ni, nj, n, n) && grid[ni][nj] == 1) {
                            int adjNode = ni*n + nj;
                            ds.union(node, adjNode);
                        }
                    }
                }
            }
        }

        int maxi = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> adjComps = new HashSet<>();
                    for (int k = 0; k < 4; k++) {
                        int ni = i + delI[k];
                        int nj = j + delJ[k];
                        if (isSafe(ni, nj, n, n) && grid[ni][nj] == 1) {
                            int adjNode = ni*n + nj;
                            int parentNode = ds.find(adjNode);
                            adjComps.add(parentNode);
                        }
                    }

                    int totalSize = 1;
                    for (int adjParentNode : adjComps) {
                        totalSize += ds.size[adjParentNode];
                    }
                    maxi = Math.max(maxi, totalSize);
                }
            }
        }

        for (int node = 0; node < n*n; node++) {
            maxi = Math.max(maxi, ds.size[ds.find(node)]);
        }

        return maxi;
    }
}