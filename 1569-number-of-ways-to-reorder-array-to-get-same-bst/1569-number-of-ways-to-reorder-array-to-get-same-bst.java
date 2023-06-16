class Solution {
    long MOD = (long)(1e9 + 7);
    long[][] pt;
    
    public int numOfWays(int[] nums) {
        int n = nums.length;
        pt = new long[n][n];
        for (int i = 0; i < n; i++) {
            pt[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= i; j++) {
                pt[i][j] = (pt[i-1][j] + pt[i-1][j-1]) % MOD;
            }
        }

        List<Long> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add((long)nums[i]);
        }

        long ans = (solve(list) - 1 + MOD) % MOD;
        return (int)ans;
    }

    public long solve(List<Long> list) {
        int n = list.size();
        if (n < 3) return 1;

        long root = list.get(0);
        List<Long> left = new ArrayList<>();
        List<Long> right = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            if (list.get(i) < root) {
                left.add(list.get(i));
            } else {
                right.add(list.get(i));
            }
        }

        long x = solve(left) % MOD;
        long y = solve(right) % MOD;
        // z = (n-1)C(left.size())
        long z = pt[n-1][left.size()] % MOD;

        return (((x * y) % MOD) * z) % MOD;
    }
}