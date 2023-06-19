class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        char[] a = s.toCharArray();
        int n = s.length();
        int i = 0;
        int j = 0;

        int maxi = 1;

        while (j < n) {
            freq[a[j] - 'A']++;

            if (j - i + 1 - maxFreq(freq) <= k) {
                maxi = Math.max(maxi, j - i + 1);
            } else {
                freq[a[i] - 'A']--;
                i++;
            }

            j++;
        }
        
        return maxi;
    }

    public int maxFreq(int[] freq) {
        int maxi = freq[0];
        for (int i = 1; i < 26; i++) {
            maxi = Math.max(maxi, freq[i]);
        }

        return maxi;
    }
}