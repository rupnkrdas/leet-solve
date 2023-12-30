class Solution {
    public boolean makeEqual(String[] words) {
        int n = words.length;
        Map<Character, Integer> map = new HashMap<>();

        for (String s : words) {
            char[] arr = s.toCharArray();
            for (char c : arr) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }

        for (int val : map.values()) {
            if ((val%n) != 0) return false;
        }

        return true;
    }
}