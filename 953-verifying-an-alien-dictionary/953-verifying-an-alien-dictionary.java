class Solution {
    int[] map = new int[26];
    public boolean isAlienSorted(String[] words, String order) {
        char[] a = order.toCharArray();
        for (int i = 0; i < 26; i++) {
            map[a[i] - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {
            if (bigger(words[i], words[i + 1])) return false;
        }

        return true;
    }

    public boolean bigger(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        for (int i = 0; i < n && i < m; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return map[s1.charAt(i) - 'a'] > map[s2.charAt(i) - 'a'];
            }
        }

        return n > m;
    }
}