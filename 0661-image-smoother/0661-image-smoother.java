class Solution {
    public int[][] imageSmoother(int[][] img) {
        int n = img.length;
        int m = img[0].length;
        int[][] ans = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int sum = 0;
                int count = 0;
                for (int i_ = i - 1; i_ <= i + 1; i_++) {
                    for (int j_ = j - 1; j_ <= j + 1; j_++) {
                        if ((i_ >= 0) && (i_ < n) && (j_ >= 0) && (j_ < m)) {
                            sum += img[i_][j_];
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