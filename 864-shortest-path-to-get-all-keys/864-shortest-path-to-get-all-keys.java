class Solution {
    int[] delI = {-1, 0, 1, 0};
    int[] delJ = {0, 1, 0, -1};
    
    public boolean isSafe(int i, int j, int n, int m) {
        return (i >= 0 && i < n && j >= 0 && j < m);
    }
    public boolean isLock(char c) {
        return (c - 'A' >= 0 && c - 'F' <= 0);
    }
    public boolean isKey(char c) {
        return (c - 'a' >= 0 && c - 'f' <= 0);
    }
    public int shortestPathAllKeys(String[] grid) {
        int count = 0; // total number of keys
        int[] start = {-1, -1};
        int n = grid.length;
        int m = grid[0].length();
        char[][] mat = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = grid[i].charAt(j);
                mat[i][j] = c;
                if (isKey(c)) count++;
                if (c == '@') {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }

        //BFS
        // we can visit each cell more than once
        // for example, in a scenario when we cant pass a lock
        // but we can collect the key for it and try visiting it again
        // therefore unlocking the lock
        // thats why, only vis is not sufficient
        // we need to maintain currentKey status somehow
        // we can do it using bit manipulation

        /*
            If we have 3 keys - '111'  - Decimal value = 8 = 2^3 - 1
            If we have 4 keys - '1111' - Decimal value = 15 = 2^4 - 1
        */
        
        int final_key_status_decimal = (int)Math.pow(2, count) - 1;
        int[][][] vis = new int[n][m][final_key_status_decimal + 1];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start[0], start[1], 0, 0}); // {i, j, steps, current_key_status}
        vis[start[0]][start[1]][0] = 1;
        while (!q.isEmpty()) {
            int[] values = q.poll();
            int i                   = values[0];
            int j                   = values[1];
            int steps               = values[2];
            int current_key_status_decimal  = values[3];

            if (current_key_status_decimal == final_key_status_decimal) return steps;

            for (int k = 0; k < 4; k++) {
                int ni = i + delI[k];
                int nj = j + delJ[k];

                if (isSafe(ni, nj, n, m) && mat[ni][nj] != '#') {
                    char ch = mat[ni][nj];

                    if (isKey(ch)) {
                        int new_key_status_decimal = current_key_status_decimal | 1 << (ch - 'a');
                        if (vis[ni][nj][new_key_status_decimal] == 0) {
                            vis[ni][nj][new_key_status_decimal] = 1;
                            q.offer(new int[]{ni, nj, steps + 1, new_key_status_decimal});
                        }
                    } else if (isLock(ch)) {
                        if (vis[ni][nj][current_key_status_decimal] == 0
                        && ((current_key_status_decimal >> (ch-'A')) & 1) == 1) {
                            vis[ni][nj][current_key_status_decimal] = 1;
                            q.offer(new int[]{ni, nj, steps + 1, current_key_status_decimal});
                        }
                    } else {
                        if (vis[ni][nj][current_key_status_decimal] == 0) {
                            vis[ni][nj][current_key_status_decimal] = 1;
                            q.offer(new int[]{ni, nj, steps + 1, current_key_status_decimal});
                        }
                    }
                }
            }
        }

        return -1;
    }
}