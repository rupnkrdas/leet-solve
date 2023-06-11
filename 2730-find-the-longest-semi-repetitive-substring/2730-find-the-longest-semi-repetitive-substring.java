class Solution {
    public int longestSemiRepetitiveSubstring(String s) {
        return f(s);
    }
    
    public int f(String s) {
        int maxi = 1;
        int n = s.length();
        char[] a = s.toCharArray();
        int i = 0;
        int j = 0;

        int pairs = 0;

        
        while (j < n) {
            int num = a[j] - '0';
            
            if (j > 0 && a[j] == a[j - 1]) {
                pairs++;
            }
            
            if (pairs <= 1) {
                maxi = Math.max(maxi, j - i + 1);
            } else {
                while (i >= 0 && i < j && a[i] != a[i + 1]) {
                    i++;
                }
                i++;
                pairs--;
            }
            
            j++;
        }
        
        return maxi;
    }
}