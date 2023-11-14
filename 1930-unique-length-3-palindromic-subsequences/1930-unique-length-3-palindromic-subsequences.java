class Solution {
    private boolean containsStr(String str, String s) {
        int i = 0, j = 0;
        while (i < str.length() && j < s.length()) {
            if (str.charAt(i) == s.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }

        return i == str.length();
    }
    public int countPalindromicSubsequence(String s) {
        // bbcbaba
        // ababcbb
        // LCS -> O(n^2) x
        // 2 pointers
        // generate all subsequences -> 2^n

        // length - 3
        // try all possible 3 length subsequences
        // _ _ _
        // 1st and last will be same
        // choices for 2nd -> 26
        // check if these exist in the string
        // check unique favours this approach

        int cnt = 0;
        Set<String> set = new HashSet<>();
        for (char c1 = 'a'; c1 <= 'z'; c1++) {
            for (char c2 = 'a'; c2 <= 'z'; c2++) {
                String str = "" + c1 + c2 + c1;
                // System.out.println(str);
                
                if (containsStr(str, s) && !set.contains(str)) {
                    // System.out.println("*****");
                    cnt++;
                    set.add(str);
                }
            }
        }

        return cnt;
    }
}