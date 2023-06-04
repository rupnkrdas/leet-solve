class Solution {
    public long matrixSumQueries(int n, int[][] queries) {
        long sum = 0;
        int[] mpr = new int[n];
        int[] mpc = new int[n];
        int r = 0, c = 0;

        int size = queries.length;


        for (int i = size - 1; i >= 0; i--) {
            int type = queries[i][0];
            int idx = queries[i][1];
            long val = queries[i][2];

            long poss = n;
            if (type == 0 && mpr[idx] == 0) {
                poss = poss - c;
                r++;
                mpr[idx] = 1;
                if (r > n) r = n;
                sum += val * poss;
            } else if (type == 1 && mpc[idx] == 0) {
                poss = poss - r;
                c++;
                mpc[idx] = 1;
                if (c > n) c = n;
                sum += val * poss;
            }
        }

        return sum;
    }
}