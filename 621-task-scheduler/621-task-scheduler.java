class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26]; // freq map for the characters
        for (char c : tasks) {
            map[c - 'A']++;
        }

        Arrays.sort(map);
        // map is sorted in ascending order with char with max freq at map[25];
        int max_value = map[25] - 1;
        int slots = max_value * n;
        for (int i = 24; i >= 0; i--) {
            slots -= Math.min(max_value, map[i]);
        }

        return (slots > 0) ? slots + tasks.length : tasks.length;
    }
}