class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int i = 0, j = n - 1;
        int maxArea = 0;

        while (i < j) {
            int h = Math.min(height[i], height[j]);
            int w = j - i;
            maxArea = Math.max(maxArea, w*h);

            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }

        return maxArea;
    }
}