import java.math.BigInteger;
class Solution {
    private boolean isPowerOfFive(long num) {
        while (num > 1) {
            if (num % 5 != 0) {
                return false;
            }
            num /= 5;
        }
        return num == 1;
    }
    private int f(String s, int start) {
        if (start == s.length()) {
            return 0;
        }

        int ans = (int)(1e9);
        long num = 0;

        for (int i = start; i < s.length(); i++) {
            num = num * 2 + (s.charAt(i) - '0');

            if (num == 0) {
                break;  
            }

            if (isPowerOfFive(num)) {
                int count = 1 + f(s, i + 1);
                ans = Math.min(count, ans);
            }
        }

        return ans;
    }

    public int minimumBeautifulSubstrings(String s) {
        int ans = f(s, 0);
        return (ans >= (int)(1e9)) ? -1 : ans;
    }
    
}