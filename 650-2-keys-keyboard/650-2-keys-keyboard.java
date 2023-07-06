class Solution {
    int[][] dp = new int[1001][1001];
    public int minSteps(int n) {
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return f(1, 0, n);
    }

    private int f(int size, int paste_size, int target) {
        if (size == target) return 0;
        if (size > target) return (int)1e9;

        if (dp[size][paste_size] != -1) return dp[size][paste_size];

        int copy_paste = 2 + f(size + size, size, target);
        int paste = (int)1e9;
        if (paste_size > 0) {
            paste = 1 + f(size + paste_size, paste_size, target);
        }

        return dp[size][paste_size] = Math.min(copy_paste, paste);
    }
    
}