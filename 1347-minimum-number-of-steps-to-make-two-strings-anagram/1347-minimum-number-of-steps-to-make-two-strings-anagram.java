class Solution {
    public int minSteps(String s, String t) {
        int n = s.length();
        char[] arr = s.toCharArray();
        char[] brr = t.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        for (char c: arr) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c: brr) {
            map.put(c, map.getOrDefault(c, 0) - 1);
        }

        int count = 0;
        for (int val : map.values()) {
            if (val < 0) count += -val;
        }

        return count;
    }
}