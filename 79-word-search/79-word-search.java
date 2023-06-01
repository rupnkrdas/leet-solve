class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        int[][] vis = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (f(0, i, j, board, "", word, vis)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean f(int index, int i, int j, char[][] grid, String str, String word, int[][] vis) {
        if (index == word.length()) {
            if(str.equals(word)) return true;
            else return false;
        }
        
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || vis[i][j] == 1) {
            return false;
        }

        



        int[] delI = {-1, 0, 1, 0};
        int[] delJ = {0, 1, 0, -1};

        if (grid[i][j] == word.charAt(index)) {
            str += word.charAt(index);
            vis[i][j] = 1;

            for (int k = 0; k < 4; k++) {
                int ni = i + delI[k];
                int nj = j + delJ[k];

                if (f(index + 1, ni, nj, grid, str, word, vis)) {
                    return true;
                }
            }
            
            str = str.substring(0, str.length() - 1);  
            vis[i][j] = 0;
        }

        return false;
    }
}