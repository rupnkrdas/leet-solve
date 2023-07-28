class Solution {
    Map<String, Boolean> dp = new HashMap<>();
    private boolean solve(int sum, int mask, int desire, int maxChoosableInteger) {
        String key = Integer.toString(sum) + "," + Integer.toString(mask);
        if (dp.containsKey(key)) return dp.get(key);

        boolean ans = false;
        for (int i = 0; i < maxChoosableInteger; i++) {
            int mask_ = 1 << i;
            if ((mask | mask_) == mask) continue;

            if (sum + (i + 1) >= desire || !solve(sum + (i + 1), mask | mask_, desire, maxChoosableInteger)) {
                ans = true;
                break;
            }
        }

        dp.put(key, ans);
        return ans;
    }
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int max_possible = maxChoosableInteger * (maxChoosableInteger + 1)/2;
        if (max_possible < desiredTotal) return false;
        return solve(0, 0, desiredTotal, maxChoosableInteger);
    }
}