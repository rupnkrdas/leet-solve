class Solution {
    int N, M;
    private boolean dfs(int i, int j, int[][] grid) {
        if (i == N - 1 && j == M - 1) return true;
        if (i >= N || j >= M || grid[i][j] == 0) return false;

        grid[i][j] = 0;
        if (dfs(i, j + 1, grid)) return true;
        return dfs(i + 1, j, grid);
    }

    // return true if no path exists initially
    // if there exists path, remove that path
    // even after removing one path, there exist other paths, return false;
    public boolean isPossibleToCutPath(int[][] grid) {
        N = grid.length;
        M = grid[0].length;

        if (!dfs(0, 0, grid)) return true;
        grid[0][0] = 1;
        if (dfs(0, 0, grid)) {
            return false;
        }

        return true;
    }
}