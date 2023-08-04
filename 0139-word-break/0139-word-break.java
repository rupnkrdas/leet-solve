class Solution {
    Map<Integer, Boolean> dp = new HashMap<>();
    Set<String> set = new HashSet<>();
    private boolean solve(int idx, String s) {
        if (idx == s.length()) {
            return true;
        }
        
        if (dp.containsKey(idx)) return dp.get(idx);

        boolean ans = false;
        for (int i = idx + 1; i <= s.length(); i++) {
            String s_ = s.substring(idx, i);
            if (set.contains(s_)) {
                if (solve(i, s)) {
                    ans = true;
                    break;
                }
            }
        }

        dp.put(idx, ans);
        return ans;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        for (String word : wordDict) {
            set.add(word);
        }

        return solve(0, s);
    }
}