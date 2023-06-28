class Tuple {
    int first;
    int second;
    int third;

    public Tuple(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}
class Solution {
    int[] delI = {-1, 0, 1, 0};
    int[] delJ = {0, 1, 0, -1};
    public boolean isExit(int i, int j, char[][] maze, int n, int m, int[] start) {
        if (i == start[0] && j == start[1]) return false;
        return (isSafe(i, j, n, m) && (maze[i][j] == '.') && (i == 0 || i == n - 1 || j == 0 || j == m - 1));
    }

    public boolean isSafe(int i, int j, int n, int m) {
        return (i >= 0 && i < n && j >= 0 && j < m);
    }

    public int nearestExit(char[][] maze, int[] start) {
        int n = maze.length;
        int m = maze[0].length;

        int[][] vis = new int[n][m];
        Queue<Tuple> q = new LinkedList<>();

        q.offer(new Tuple(start[0], start[1], 0));
        vis[start[0]][start[1]] = 1;
        
        while (!q.isEmpty()) {
            Tuple tuple = q.poll();
            int i = tuple.first;
            int j = tuple.second;
            int steps = tuple.third;
            if (isExit(i, j, maze, n, m, start)) return steps;

            for (int k = 0; k < 4; k++) {
                int ni = i + delI[k];
                int nj = j + delJ[k];

                if (isSafe(ni, nj, n, m)
                && vis[ni][nj] == 0
                && maze[ni][nj] == '.') {
                    vis[ni][nj] = 1;
                    q.offer(new Tuple(ni, nj, steps + 1));
                }
            }
        }

        return -1;
    }
}