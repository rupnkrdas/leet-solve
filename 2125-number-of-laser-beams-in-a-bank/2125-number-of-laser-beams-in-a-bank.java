class Solution {
    public int numberOfBeams(String[] grid) {
        int n = grid.length;
        int m = grid[0].length();
        // 0 1 1 0 0 1
        // 0 0 1 0 0 0
        // 0 1 0 1 0 0
        // 0 0 1 0 0 0

        int prevRow = -1;
        int prevCount = 0;

        int total = 0;
        for (int i = 0; i < n; i++) {
            char[] arr = grid[i].toCharArray();
            int currCount = 0;

            for (int j = 0; j < m; j++) {
                if (arr[j] == '1') currCount++;
                if (prevRow != -1 && i > prevRow && prevCount > 0 && arr[j] == '1') {
                    total += prevCount;
                }
            }

            if (currCount > 0) {
                prevCount = currCount;
                prevRow = i;
            }
        }

        return total;
    }
}