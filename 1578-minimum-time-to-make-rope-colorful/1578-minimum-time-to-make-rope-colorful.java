class Solution {
    public int minCost(String colors, int[] time) {
        int n = colors.length();
        char[] arr = colors.toCharArray();
        // a b a a c
        
        int total = 0;
        for (int i = 0; i < n; i++) {
            char ch = arr[i];

            int j = i;
            int maxi = time[i];
            int sum = time[i];
            while (j + 1 < n && arr[j + 1] == ch) {
                j++;
                sum += time[j];
                maxi = Math.max(maxi, time[j]);
            }

            if (j != i) {
                total += sum - maxi;
            }

            // System.out.println(i+","+j);
            // System.out.println("maxi: " + maxi + " sum: " + sum);

            i = j;
        }

        return total;
    }
}