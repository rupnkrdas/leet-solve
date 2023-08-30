class Solution {
    public int minOperations(List<Integer> nums, int target) {
        int[] count = new int[31];
        long sum = 0;
        for (int num : nums) {
            count[(int)(Math.log(num)/Math.log(2))]++;
            sum += num;
        }

        int ops = 0;

        if ((long)target > sum) return -1;

        int i = 0;
        while (i < 30) {
            if ((target & (1<<i)) > 0) {
                if (count[i] > 0) {
                    count[i]--;
                } else {
                    int j = i;
                    while (j < 30 && count[j] == 0) {
                        j++;
                        ops++;
                    }
                    count[j]--;

                    while (j > i) {
                        count[--j]++;
                    }
                }
            }

            count[i + 1] += count[i]/2;
            i++;
        }

        return ops;
    }
}