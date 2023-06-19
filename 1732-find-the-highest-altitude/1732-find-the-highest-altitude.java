class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int curr = 0;
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            curr += gain[i];
            maxi = Math.max(maxi, curr);
        }

        return (maxi > 0) ? maxi : 0;
    }
}