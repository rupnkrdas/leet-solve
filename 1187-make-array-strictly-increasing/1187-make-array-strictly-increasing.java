class Solution {
    Map<Integer, Map<Integer, Integer>> dp = new HashMap<>();
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Arrays.sort(arr2);

        int ans = solve(0, Integer.MIN_VALUE, arr1, arr2);

        return (ans != (int)(1e9+1)) ? ans : -1;
    }

    public int solve(int i, int prevElement, int[] arr1, int[] arr2) {
        // base case
        if (i == arr1.length) {
            return 0;
        }

        if (dp.containsKey(i) && dp.get(i).containsKey(prevElement)) {
            return dp.get(i).get(prevElement);
        }

        // replacement
        int ceil = upper_bound(arr2, prevElement);
        int op1 = (int)(1e9+1);
        if (ceil != -1) {
            op1 = 1 + solve(i + 1, arr2[ceil], arr1, arr2);
        }

        //skip
        int op2 = (int)(1e9+1);
        if (arr1[i] > prevElement) {
            op2 = solve(i + 1, arr1[i], arr1, arr2);
        }

        // return dp[i][prevElement] = Math.min(op1, op2);
        if (!dp.containsKey(i)) {
            dp.put(i, new HashMap<>());
        }
        
        dp.get(i).put(prevElement, Math.min(op1, op2));

        return dp.get(i).get(prevElement);
    }

    public int upper_bound(int[] arr, int target) {
        int res = -1;
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                res = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return res;
    }
}