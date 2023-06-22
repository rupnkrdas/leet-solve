class Solution {
    Map<String, Boolean> map = new HashMap<>();
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        return f(0, 0, 0, s1.toCharArray(), s2.toCharArray(), s3.toCharArray(), s1.length(), s2.length(), s3.length());
    }

    public boolean f(int p1, int p2, int p3, char[] s1, char[] s2, char[] s3, int len1, int len2, int len3) {
        if (p3 == len3) {
            if (p1 == len1 && p2 == len2) return true;
            return false; 
        }

        String key = Integer.toString(p1) + "," + Integer.toString(p2) + "," + Integer.toString(p3);
        if (map.containsKey(key)) return map.get(key);


        boolean op1 = false;
        boolean op2 = false;
        if (p3 < len3 && p1 < len1 && s3[p3] == s1[p1]) {
            op1 = f(p1 + 1, p2, p3 + 1, s1, s2, s3, len1, len2, len3);
        }
        if (p3 < len3 && p2 < len2 && s3[p3] == s2[p2]) {
            op2 = f(p1, p2 + 1, p3 + 1, s1, s2, s3, len1, len2, len3);
        }

        boolean ans = op1 || op2;
        map.put(key, ans);
        return ans;
    }
}