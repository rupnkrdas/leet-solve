class Solution {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) return false;

        int[] map = new int[26];
        int diff = 0;
        if (s.equals(goal)) {
            for (int i = 0; i < s.length(); i++) {
                map[s.charAt(i) - 'a']++;
                if (map[s.charAt(i) - 'a'] > 1) return true;
            }
        } else {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != goal.charAt(i)) diff++;
                map[s.charAt(i) - 'a']++;
                map[goal.charAt(i) - 'a']--;
            }
        }

        for (int i = 0 ; i < 26; i++) {
            if (map[i] != 0) return false;
        }
        
        return diff == 2;
    }
}