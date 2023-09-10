class Solution {
    // returns the minimum number of moves needed to reach final state
    // final state is where all the cells have 1
    private int f(int idx, List<int[]> zeroes, List<int[]> extras, int[][] grid, int n, int m) {
        if (idx == zeroes.size()) return 0;
        int moves = (int)(1e9);

        for (int i = 0; i < extras.size(); i++) {
            int i_ = extras.get(i)[0];
            int j_ = extras.get(i)[1];
            
            if (grid[i_][j_] > 1) {
                grid[i_][j_]--;
                int cost = Math.abs(zeroes.get(idx)[0]-i_) + Math.abs(zeroes.get(idx)[1]-j_);
                moves = Math.min(moves, cost + f(idx + 1, zeroes, extras, grid, n, m));
                grid[i_][j_]++;
            }
        }

        return moves;
    }
    public int minimumMoves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for (int[] row : grid) {
          System.out.println(Arrays.toString(row));  
        }
        List<int[]> extras = new ArrayList<>();
        List<int[]> zeroes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] > 1) extras.add(new int[]{i, j});
                if (grid[i][j] == 0) zeroes.add(new int[]{i, j});
            }
        }

        return f(0, zeroes, extras, grid, n, m);

    }
}