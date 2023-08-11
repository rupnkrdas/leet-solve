class Solution {
    private int bs(int spell, int[] potions, long success, int m) {
        int start = 0;
        int end = m - 1;

        int ans = m;
        while (start <= end) {
            int mid = start + (end - start)/2;

            long val = (long)spell*(long)potions[mid];
            if (val >= success) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        Arrays.sort(potions);

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int spell = spells[i];
            ans[i] = m - bs(spell, potions, success, m);
        }

        return ans;
    }
}