class Pair {
    int row;
    int col;

    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public void dfs(int i, int j, int[][] vis, char[][] grid) {
        vis[i][j] = 1;
        // Queue<Pair> q = new LinkedList<>();
        // q.offer(new Pair(i, j));

        int n = grid.length;
        int m = grid[0].length;

        int[] delX = {-1, 0, 1, 0};
        int[] delY = {0, 1, 0, -1};

        // while (!q.isEmpty()) {
        //     Pair pair = q.poll();
        //     int x = pair.row;
        //     int y = pair.col;

            for (int k = 0; k < 4; k++) {
                
                int nRow = i + delX[k];
                int nCol = j + delY[k];

                if (nRow >= 0
                && nRow < n
                && nCol >= 0
                && nCol < m
                && grid[nRow][nCol] == '1'
                && vis[nRow][nCol] != 1) {
                    dfs(nRow, nCol, vis, grid);
                }
            }
        }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && vis[i][j] == 0) {
                    count++;
                    dfs(i, j, vis, grid);
                }
            }
        }


        return count;
    }
}