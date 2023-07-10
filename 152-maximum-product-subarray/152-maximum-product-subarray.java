class Solution {
    public int maxProduct(int[] nums) {
        int global_max = Arrays.stream(nums).max().getAsInt();
        int curr_max = 1, curr_min = 1;

        for (int num : nums) {
            if (num == 0) {
                //reset everything to 1
                curr_max = 1;
                curr_min = 1;
                continue;
            }

            int temp = curr_max;
            curr_max = Math.max(curr_max * num, Math.max(curr_min * num, num));
            curr_min = Math.min(temp * num, Math.min(curr_min * num, num));

            global_max = Math.max(global_max, curr_max);
        }

        return global_max;
    }
}