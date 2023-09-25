class Solution {
    public char findTheDifference(String s, String t) {
        int[] f = new int[26];
        for (int i = 0; i < s.length(); i++) {
            f[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            f[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (f[i] != 0) return (char)(i + 'a');
        }

        return '0';
    }
}