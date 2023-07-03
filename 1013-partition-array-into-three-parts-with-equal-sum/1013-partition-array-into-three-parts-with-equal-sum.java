class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int total_sum = 0;
        for (int num : arr) {
            total_sum += num;
        }
        if (total_sum % 3 != 0) return false;

        int find = total_sum / 3;
        int n = arr.length;
        int count = 0;
        int curr_sum = 0;
        for (int i = 0; i < arr.length; i++) {
            curr_sum += arr[i];
            if (curr_sum == find) {
                curr_sum = 0;
                count++;
            }
        }

        return count >= 3;
    }
}