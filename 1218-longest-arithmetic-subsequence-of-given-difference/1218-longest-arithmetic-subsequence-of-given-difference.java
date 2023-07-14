class Solution {
    public int longestSubsequence(int[] arr, int diff) {
        int n = arr.length;
        Map<Integer, Integer> dp = new HashMap<>();
        int maxi = 1;
        for (int i = 0; i < n; i++) {
            int prev_element = arr[i] - diff;
            if (dp.containsKey(prev_element)) {
                dp.put(arr[i], dp.get(prev_element) + 1);

                maxi = Math.max(maxi, dp.get(arr[i]));
            } else {
                dp.put(arr[i], 1);
            }
        }

        return maxi;
    }
}