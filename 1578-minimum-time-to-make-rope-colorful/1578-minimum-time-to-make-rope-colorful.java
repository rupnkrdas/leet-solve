class Solution {
    public int minCost(String colors, int[] time) {
        int n = colors.length();
        char[] arr = colors.toCharArray();
        // a b a a c
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ch = arr[i];

            int j = i;
            while (j + 1 < n && arr[j + 1] == ch) j++;
            map.put(i, j);

            i = j;
        }

        // System.out.println(map);

        int total = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            int start = e.getKey();
            int end = e.getValue();
            if (start == end) continue;

            int maxi = Integer.MIN_VALUE;
            int sum = 0;
            for (int i = start; i <= end; i++) {
                sum += time[i];
                maxi = Math.max(maxi, time[i]);
            }

            // System.out.println(sum - maxi);

            total += sum - maxi;
        }

        return total;
    }
}