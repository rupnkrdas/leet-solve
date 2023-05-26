class Solution {
    int[] dp;
    public int f(int[] s) {
        int n = s.length;
        // dp = new int[n + 3];
        int next1 = 0;
        int next2 = 0;
        int next3 = 0;
        for (int i = n - 1; i >= 0; i--) {
            int curr = 0;
            if (i >= s.length) curr = 0;
            else {
                int maxi = Integer.MIN_VALUE;
                maxi = Math.max(maxi, s[i] - next1);
                if (i + 1 < s.length) {
                    maxi = Math.max(maxi, s[i] + s[i + 1] - next2);
                }
                if (i + 2 < s.length) {
                    maxi = Math.max(maxi, s[i] + s[i + 1] + s[i + 2] - next3);
                }

                curr = maxi;

                next3 = next2;
                next2 = next1;
                next1 = curr;
            }
        }

       return next1;
    }
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;

        int alice_wins = f(stoneValue);
        if (alice_wins > 0) return "Alice";
        if (alice_wins == 0) return "Tie";
        else {
            return "Bob";
        }
    }
} 