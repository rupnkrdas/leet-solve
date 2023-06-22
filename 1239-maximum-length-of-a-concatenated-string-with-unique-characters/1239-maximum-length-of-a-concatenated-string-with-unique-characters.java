class Solution {
    Map<String, Integer> map = new HashMap<>();
    public int maxLength(List<String> arr) {
        return f(0, "", arr);
    }

    public int f(int idx, String s, List<String> arr) {
        if (idx == arr.size()) {
            return 0;
        }

        String key = Integer.toString(idx) + "," + s;
        if (map.containsKey(key)) return map.get(key);

        String temp = s;
        int take = 0;
        if (canTake(s, arr.get(idx))) {
            take = arr.get(idx).length() + f(idx + 1, s + arr.get(idx), arr);
        }
        int notTake = f(idx + 1, temp, arr);

        int ans = Math.max(take, notTake);
        map.put(key, ans);
        return ans;
    }

    public boolean canTake(String s2, String s1) {
        char[] map = new char[26];
        for (int i = 0; i < s1.length(); i++) {
            if (map[s1.charAt(i) - 'a'] >= 1) {
                return false;
            }
            map[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s2.length(); i++) {
            if (map[s2.charAt(i) - 'a'] >= 1) {
                return false;
            }
        }

        return true;
    }
} 