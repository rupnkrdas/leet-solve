class Solution {
    Map<String, Boolean> map = new HashMap<>();
    public boolean isScramble(String s1, String s2) {
        return f(s1, s2);
    }

    public boolean f(String s1, String s2) {
        if (s1.equals(s2)) return true;
        if (s1.length() != s2.length()) return false;

        String key = s1 + "," + s2;
        if (map.containsKey(key)) return map.get(key);

        boolean ans = false;
        int n = s1.length();
        for (int i = 1; i < n; i++) {
            boolean swapped = f(s1.substring(0, i), s2.substring(n - i))
                                && f(s1.substring(i), s2.substring(0, n - i));
            if (swapped) {
                ans = true;
                break;
            }
        
            boolean not_swapped = f(s1.substring(0, i), s2.substring(0, i))
                                    && f(s1.substring(i), s2.substring(i));
            if (not_swapped) {
                ans = true;
                break;
            }
        }

        map.put(key, ans);
        return ans;
    }
}