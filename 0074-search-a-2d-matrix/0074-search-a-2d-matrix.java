class Solution {
    public boolean searchMatrix(int[][] grid, int target) {
        int n = grid.length;
        int m = grid[0].length;
        
        int start = 0;
        int end = n * m - 1;

        while (start <= end) {
            int mid = start + (end - start)/2;

            int element = grid[mid/m][mid%m];
            if (target == element) return true;
            else if (target > element) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
    }
}