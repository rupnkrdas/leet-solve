class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        int n = arr.length;
        if (n == 2) return true;

        Arrays.sort(arr);
        int d = arr[1] - arr[0];
        for (int i = 1; i < n - 1; i++) {
            int d1 = arr[i + 1] - arr[i];
            if (d1 != d) return false;
        }

        return true;
    }
}