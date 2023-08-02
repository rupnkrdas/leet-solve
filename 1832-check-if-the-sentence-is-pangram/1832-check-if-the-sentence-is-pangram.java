class Solution {
    public boolean checkIfPangram(String sentence) {
        char[] arr = sentence.toCharArray();
        int[] map = new int[26];
        for (char c : arr) {
            map[c-'a']++;
        }

        for (int f : map) {
            if (f == 0) return false;
        }

        return true;
    }
}