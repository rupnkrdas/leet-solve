class Solution {
    // Map<String, Integer> map = new HashMap<>();
    int[][] dp = new int[1001][10003];
    public int tallestBillboard(int[] rods) {
        for (int i = 0; i < 1001; i++) {
            for (int j = 0; j < 10003; j++) {
                dp[i][j] = -1;
            }
        }

        int ans = f(0, rods, 0);
        return ans/2;
    }

    public int f(int idx, int[] nums, int diff) {
        if (idx == nums.length) {
            if (diff == 0) return 0;
            else return (int)(-1e9);
        }
        
        if (dp[idx][diff + 5000] != -1) return dp[idx][diff + 5000];

        // String key = Integer.toString(idx) + "," + Integer.toString(diff);
        // if (map.containsKey(key)) return map.get(key);


        int take1 = nums[idx] + f(idx + 1, nums, diff + nums[idx]);
        int take2 = nums[idx] + f(idx + 1, nums, diff - nums[idx]);
        int notTake = f(idx + 1, nums, diff);

        return dp[idx][diff + 5000] = Math.max(take1, Math.max(take2, notTake));
        // map.put(key, ans);
        // return ans;
    }
}