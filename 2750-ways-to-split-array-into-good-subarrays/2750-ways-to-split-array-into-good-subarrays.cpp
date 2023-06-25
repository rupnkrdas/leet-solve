class Solution {
public:
    const int MOD = 1e9 + 7;
    int dp[100001][2];

    int f(int i, int found1, std::vector<int>& nums) {
        if (i >= nums.size()) {
            return (found1 == 1) ? 1 : 0;
        }

        if (dp[i][found1] != -1)
            return dp[i][found1];

        int ans = 0;
        if (nums[i] == 0) {
            if (found1 == 1) {
                // split
                int a = f(i + 1, 0, nums);

                // dont split
                int b = f(i + 1, 1, nums);

                ans = (ans % MOD + a % MOD + b % MOD) % MOD;
            } else {
                // continue looking
                // cannot split
                ans = (ans % MOD + f(i + 1, 0, nums) % MOD) % MOD;
            }
        } else { // nums[i] == 1
            // found 1
            // have to split, no other option
            ans = (ans % MOD + f(i + 1, 1, nums) % MOD) % MOD;
        }

        return dp[i][found1] = ans % MOD;
    }
    int numberOfGoodSubarraySplits(vector<int>& nums) {
        memset(dp, -1, sizeof(dp));
        return f(0, 0, nums);
    }
};