class Solution {
    /**
        idx     : indexing in the array
        k       : number of characters that we can delete
        last    : previous character
        count   : freq of previous character until idx 
     */
    Map<String, Integer> dp = new HashMap<>();
    private int f(int idx, int k, char[] arr, char last, int count) {
        if (idx == arr.length) return 0;

        String key = Integer.toString(idx) + "," + Integer.toString(k) + "," + last + "," + Integer.toString(count);
        if (dp.containsKey(key)) return dp.get(key);

        // keep
        int keep = Integer.MAX_VALUE;
        if (arr[idx] == last) {
            int add = 0;
            if (count == 1 || count == 9 || count == 99) add++;
            keep = add + f(idx + 1, k, arr, last, count + 1);
        } else {
            keep = 1 + f(idx + 1, k, arr, arr[idx], 1);
        }

        // delete
        int delete = (k > 0) ? f(idx + 1, k - 1, arr, last, count) : Integer.MAX_VALUE;

        int ans = Math.min(keep, delete);
        dp.put(key, ans);
        return ans;
    }

    public int getLengthOfOptimalCompression(String s, int k) {
        return f(0, k, s.toCharArray(), '$', 0);
    }
}