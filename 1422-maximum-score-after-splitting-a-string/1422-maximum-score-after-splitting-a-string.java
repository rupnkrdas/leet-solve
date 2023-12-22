class Solution {
    public int maxScore(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int[] left  = new int[n - 1];
        int[] right = new int[n - 1];
        
        int l = 0;
        for (int i = 0; i < n - 1; i++) {
            l += (arr[i] == '0') ? 1 : 0;
            left[i] = l;
        }
        
        int r = 0;
        for (int i = n - 1; i > 0; i--) {
            r += (arr[i] == '1') ? 1 : 0;
            right[i - 1] = r;
        }
        
        int maxi = 0;
        for (int i = 0; i < n - 1; i++) {
            maxi = Math.max(maxi, left[i] + right[i]);
        }
        
        return maxi;
    }
}