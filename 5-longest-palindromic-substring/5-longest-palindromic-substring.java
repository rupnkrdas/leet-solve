class Solution {
    public String longestPalindrome(String s) {
        int maxLength = 0;
        String res = "";
        int n = s.length();
        for (int i = 0; i < n; i++) {
            // check for odd length palindromes
            int l = i;
            int r = i;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > maxLength) {
                    res = s.substring(l, r + 1);
                    maxLength = r - l + 1;
                }
                l--;
                r++;
            }

            // check for even length palindromes
            l = i;
            r = i + 1;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > maxLength) {
                    res = s.substring(l, r + 1);
                    maxLength = r - l + 1;
                }
                l--;
                r++;
            }
        }

        return res;
    }
}