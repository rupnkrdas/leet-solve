class Solution {
    Set<String> set;
    int[] dp;
    public int minExtraChar(String s, String[] dictionary) {
        set = new HashSet<>();
        for (int i = 0; i < dictionary.length; i++) {
            set.add(dictionary[i]);
        }
        
        int n = s.length();
        dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }
        
        return f(0, s);
    }
    
    public int f(int i, String s) {
        if (i == s.length()) {
            return 0;
        }
        
        if (dp[i] != -1) return dp[i];
    
        // take 
        int take = 1 + f(i + 1, s);
        
        // not take
        int notTake = Integer.MAX_VALUE;
        String str = "";
        for (int j = i; j < s.length(); j++) {
            str += s.charAt(j);
            if (set.contains(str)) {
                notTake = Math.min(notTake, f(j + 1, s));
            }
        }
        
        return dp[i] = Math.min(take, notTake);
    }
}