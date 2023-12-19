class Solution {
    public boolean isSafe(int i, int j, int n, int m) {
        return (i >= 0 && i < n && j >= 0 && j < m);
    }
    public int[][] imageSmoother(int[][] img) {
        int n = img.length;
        int m = img[0].length;
        int[][] ans = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int sum = 0;
                int count = 0;
                for (int dx = -1; dx <= 1; dx++) {
                    for (int dy = -1; dy <= 1; dy++) {
                        int ni = i + dx;
                        int nj = j + dy;

                        if (isSafe(ni, nj, n, m)) {
                            sum += img[ni][nj];
                            count++;
                        }
                    }
                }
                
                // System.out.println("("+ i + ", " + j + " -> " + "sum : " + sum + " count : " + count);
                ans[i][j] = sum / count;
            }
        }

        return ans;
    }
}