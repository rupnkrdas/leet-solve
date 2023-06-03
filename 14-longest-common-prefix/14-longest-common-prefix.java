class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if (n == 1) return strs[0];
        String ans = strs[0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < Math.min(strs[i].length(), ans.length()); j++) {
                if (strs[i].charAt(j) == ans.charAt(j)) {

                } else {
                    ans = ans.substring(0, j);
                    break;
                }
            }
            ans = ans.substring(0, Math.min(strs[i].length(), ans.length()));
        }

        return ans;
    }
}