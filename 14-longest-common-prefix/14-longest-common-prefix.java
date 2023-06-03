class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if (n == 1) return strs[0];
        String pre = "";
        for (int i = 0; i < Math.min(strs[0].length(), strs[1].length()); i++) {
            if (strs[0].charAt(i) == strs[1].charAt(i)) {
                pre += strs[0].charAt(i);
            } else {
                break;
            }
        }

        for (int i = 2; i < n; i++) {
            String common = "";
            char[] a = pre.toCharArray();
            char[] b = strs[i].toCharArray();
            int p1 = 0;
            int p2 = 0;
            while (p1 < a.length && p2 < b.length && a[p1] == b[p2]) {
                common += a[p1];
                p1++;
                p2++;
            }
            pre = common;
        }

        return pre.toString();
    }
}