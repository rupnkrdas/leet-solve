class Solution {
    private boolean isPre(String s1, String s2) {
        // return if s1 is predecessor of s2
        int i = 0;
        int j = 0;

        int n = s1.length();
        int m = s2.length();
        if (n + 1 != m) return false;
    
        while (i < n && j < m) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }

        return i == n && j <= m;
    }
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (s1, s2) -> s1.length() - s2.length());
        // System.out.println(Arrays.toString(words));
        int n = words.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int maxi = 1;
        for (int index = 0; index < n; index++) {
            for (int prevIndex = 0; prevIndex < index; prevIndex++) {
                // System.out.println("words[prevIndex] : " + words[prevIndex] + " words[index] : " + words[index] + " " + isPre(words[prevIndex], words[index]));
                if (isPre(words[prevIndex], words[index])) {
                    dp[index] = Math.max(dp[index], dp[prevIndex] + 1);
                }
            }
            maxi = Math.max(maxi, dp[index]);
        }

        return maxi;
    }
}