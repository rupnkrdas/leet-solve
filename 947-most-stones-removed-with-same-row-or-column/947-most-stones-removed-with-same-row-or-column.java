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
    public int removeStones(int[][] stones) {
        int maxRow = 0;
        int maxCol = 0;
        for (int[] stone : stones) {
            maxRow = Math.max(maxRow, stone[0]);
            maxCol = Math.max(maxCol, stone[1]);
        }
        DS ds = new DS(maxRow + maxCol + 1);
        Map<Integer, Boolean> map = new HashMap<>();
        for (int[] stone : stones) {
            int row = stone[0];
            int col = stone[1] + maxRow + 1;
            ds.union(row, col);
            map.put(row, true);
            map.put(col, true);
        }

        int connectedComps = 0;
        for (int stone : map.keySet()) {
            if (ds.parent[stone] == stone) connectedComps++;
        }

        return stones.length - connectedComps;
    }
}