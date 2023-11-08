class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < left.length; i++) {
            maxi = Math.max(maxi, Math.abs(left[i]-0));
        }
        for (int i = 0; i < right.length; i++) {
            maxi = Math.max(maxi, Math.abs(right[i]-n));
        }

        return maxi;
    }
}