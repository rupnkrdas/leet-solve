class Solution {
    private long MOD = (long)(1e9 + 7);
    long[][][][] dp = new long[101][11][2][2];
    private void resetDP() {
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 11; j++) {
                for (int k = 0; k < 2; k++) {
                    for (int l = 0; l < 2; l++) {
                        dp[i][j][k][l] = -1;
                    }
                }
            }
        }
    }
    private long solve(int idx, String num, int prev, boolean isTight, boolean isZero) {
        if (idx == num.length()) {
            return isZero?0:1;
        }

        if (dp[idx][prev + 1][isTight?1:0][isZero?1:0] != -1) {
            return dp[idx][prev + 1][isTight?1:0][isZero?1:0];
        }
        
        int limit = num.charAt(idx) - '0';
        if (!isTight) {
            limit = 9;
        }

        long ans = 0;
        for (int digit = 0; digit <= limit; digit++) {
            boolean nextTight = isTight && (digit == limit);
            boolean isNextZero = isZero && (digit == 0);

            if (isZero || (Math.abs(digit - prev) == 1)) {
                ans = ans%MOD + solve(idx + 1, num, digit, nextTight, isNextZero)%MOD;
            }
        }

        return dp[idx][prev + 1][isTight?1:0][isZero?1:0] = ans;
    }
    public int countSteppingNumbers(String low, String high) {
        resetDP();
        long ans = solve(0, high, -1, true, true);
        resetDP();
        ans -= solve(0, low, -1, true, true);
        ans = (ans + MOD)%MOD;

        boolean isLowValid = true;
        for (int i = 0; i < low.length() - 1; i++) {
            if (Math.abs(low.charAt(i) - low.charAt(i + 1)) != 1) {
                isLowValid = false;
                break;
            }
        }

        ans = (ans + MOD + (isLowValid?1:0))%MOD;

        return (int)ans;
    }
}