class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        int[][] vis = new int[n][m];

        int[] delRow = { -1, 0, 1, 0 };
        int[] delCol = { 0, 1, 0, -1 };

        // left boundary
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') {
                dfs(i, 0, board, vis, delRow, delCol, n, m);
            }
        }

        // right boundary
        for (int i = 0; i < n; i++) {
            if (board[i][m - 1] == 'O') {
                dfs(i, m - 1, board, vis, delRow, delCol, n, m);
            }
        }

        // top boundary
        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O') {
                dfs(0, j, board, vis, delRow, delCol, n, m);
            }
        }

        // bottom boundary
        for (int j = 0; j < m; j++) {
            if (board[n - 1][j] == 'O') {
                dfs(n - 1, j, board, vis, delRow, delCol, n, m);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' && vis[i][j] == 0) {
                    board[i][j] = 'X';
                }
            }
        }

    }

    public void dfs(int i, int j, char[][] board, int[][] vis, int[] delRow, int[] delCol, int n, int m) {
        vis[i][j] = 1;

        for (int k = 0; k < 4; k++) {
            int nRow = i + delRow[k];
            int nCol = j + delCol[k];

            if (nRow >= 0 && nRow < n
                    && nCol >= 0 && nCol < m
                    && board[nRow][nCol] == 'O'
                    && vis[nRow][nCol] == 0) {
                dfs(nRow, nCol, board, vis, delRow, delCol, n, m);
            }
        }

    }
}