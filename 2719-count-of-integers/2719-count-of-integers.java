class Solution {
    Map<String, Long> map = new HashMap<>();
    private long MOD = (long)(1e9 + 7);
    private int getSum(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += s.charAt(i) - '0';
        }

        return sum;
    }
    private long solve(int idx, String num, int sum, boolean isTight, int minSum, int maxSum) {
        if (idx == num.length()) {
            if (sum >= minSum && sum <= maxSum) return 1;
            return 0;
        }

        String key = Integer.toString(idx) + "," + Integer.toString(sum) + "," + Boolean.toString(isTight);
        if (map.containsKey(key)) return map.get(key);

        int limit = num.charAt(idx) - '0';
        if (!isTight) {
            limit = 9;
        }
        
        long ans = 0;
        for (int digit = 0; digit <= limit; digit++) {
            boolean nextTight = isTight && (digit == limit);

            ans = ans%MOD + solve(idx + 1, num, sum + digit, nextTight, minSum, maxSum)%MOD;
        }

        map.put(key, ans%MOD);
        return ans%MOD;
    }
    public int count(String num1, String num2, int min_sum, int max_sum) {
        long ans = solve(0, num2, 0, true, min_sum, max_sum);
        map.clear();
        ans -= solve(0, num1, 0, true, min_sum, max_sum);
        ans = (ans + MOD)%MOD;

        // check for num1
        int sum = getSum(num1);
        boolean isNum1Valid = false;
        if (sum >= min_sum && sum <= max_sum) isNum1Valid = true;

        ans = (ans + (isNum1Valid?1:0) + MOD)%MOD;

        return (int)ans;
    }
}