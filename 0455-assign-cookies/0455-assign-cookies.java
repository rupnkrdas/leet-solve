class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int i = 0, j = 0;
        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0;
        while (i < g.length && j < s.length) {
            if (s[j] < g[i]) j++;
            else {
                count++;
                i++;
                j++;
            }
        }

        return count;
    }
}