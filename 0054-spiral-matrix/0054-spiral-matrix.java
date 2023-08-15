class Solution {
    private boolean isGood(int left, int right, int top, int bottom) {
        return left <= right && top <= bottom;
    }
    public List<Integer> spiralOrder(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int left = 0, right = m - 1;
        int top = 0, bottom = n - 1;

        List<Integer> list = new ArrayList<>();

        while (isGood(left, right, top, bottom)) {
            if (isGood(left, right, top, bottom)) {
                // left -> right, top is constant
                for (int j = left; j <= right; j++) {
                    list.add(grid[top][j]);
                }
                top++;
            }

            if (isGood(left, right, top, bottom)) {
                // top -> bottom, right is constant
                for (int i = top; i <= bottom; i++) {
                    list.add(grid[i][right]);
                }
                right--;
            }

            if (isGood(left, right, top, bottom)) {
                // left -> right, bottom is constant
                for (int j = right; j >= left; j--) {
                    list.add(grid[bottom][j]);
                }
                bottom--;
            }

            if (isGood(left, right, top, bottom)) {
                // bottom -> top, left is constant
                for (int i = bottom; i >= top; i--) {
                    list.add(grid[i][left]);
                }
                left++;
            }
        }

        return list;
    }
}