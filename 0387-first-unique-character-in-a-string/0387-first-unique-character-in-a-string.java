class Solution {
    public int firstUniqChar(String s) {
        int[] map = new int[26];
        char[] arr = s.toCharArray();
        for (char c : arr) {
            map[c-'a']++;
        }

        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (map[c-'a'] == 1) return i;
        }

        return -1;
    }
}