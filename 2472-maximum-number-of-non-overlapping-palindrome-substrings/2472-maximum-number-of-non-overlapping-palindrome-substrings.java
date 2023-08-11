class Solution {
    int[] dp;
    private boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;

        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }

        return true;
    }
    private int f(int idx, int k, String s) {
        if (idx == s.length()) return 0;

        if (dp[idx] != -1) return dp[idx];

        int take = 0;
        String sub = "";
        for (int i = idx; i < s.length(); i++) {
            sub += s.charAt(i);
            // System.out.println(sub);
            if (isPalindrome(sub) && sub.length() >= k) {
                take = 1 + f(i + 1, k, s);
                break;
            }
        }

        int notTake = f(idx + 1, k, s);

        return dp[idx] = Math.max(take, notTake);
    }
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return f(0, k, s);
    }
}