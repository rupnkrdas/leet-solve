class Solution {
    int[] delI = {-1, 0, 1, 0};
    int[] delJ = {0, 1, 0, -1};
    public boolean isSafe(int i, int j, int n, int m) {
        return (i >= 0 && i < n && j >= 0 && j < m);
    }
    private void fill_grid(List<List<Integer>> grid, int[][] g, int[][] vis) {
        int n = grid.size();
        int m = grid.get(0).size();
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(i).size(); j++) {
                if (grid.get(i).get(j) == 1) {
                    q.offer(new int[]{i, j, 0});
                    g[i][j] = 0;
                    vis[i][j] = 1;
                }
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] node = q.poll();
                int i = node[0];
                int j = node[1];
                int distance = node[2];
                g[i][j] = distance;

                for (int k = 0; k < 4; k++) {
                    int ni = i + delI[k];
                    int nj = j + delJ[k];

                    if (isSafe(ni, nj, n, m)
                    && vis[ni][nj] == 0) {
                        vis[ni][nj] = 1;
                        q.offer(new int[]{ni, nj, distance + 1});
                    }
                }
            }
        }
    }

    private boolean isGood(int i, int j, int[][] grid, int[][] vis, int n, int m, int sf) {
        if (i == n - 1 && j == m - 1) {
            return grid[i][j] != 0;
        }

        vis[i][j] = 1;

        boolean ans = false;
        for (int k = 0; k < 4; k++) {
            int ni = i + delI[k];
            int nj = j + delJ[k];

            if (isSafe(ni, nj, n, m) && vis[ni][nj] == 0 && grid[ni][nj] >= sf) {
                if (isGood(ni, nj, grid, vis, n, m, sf)) {
                    ans = true;
                    break;
                }
            }
        }

        return ans;
    }
    
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int m = grid.get(0).size();
        int[][] g = new int[n][m];
        int[][] vis = new int[n][m];
        fill_grid(grid, g, vis);
        // for (int[] row : g) {
        //     System.out.println(Arrays.toString(row));
        // }

        int start = 0;
        int end = Math.min(n, m);

        int maxi = 0;
        while (start <= end) {
            int mid = start + (end - start)/2;

            vis = new int[n][m];
            if (g[0][0] >= mid && isGood(0, 0, g, vis, n, m, mid)) {
                maxi = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return maxi;
    }
}