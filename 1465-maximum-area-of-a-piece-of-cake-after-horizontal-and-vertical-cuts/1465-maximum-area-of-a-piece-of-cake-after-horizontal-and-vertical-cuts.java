class Solution {
    long mod = (int)1e9 + 7;
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        long[] hor = new long[horizontalCuts.length + 2];
        int n = hor.length;
        hor[0] = 0;
        hor[n - 1] = h;
        for (int i = 0; i < horizontalCuts.length; i++) {
            hor[i + 1] = horizontalCuts[i];
        }

        Arrays.sort(verticalCuts);
        long[] ver = new long[verticalCuts.length + 2];
        int m = ver.length;
        ver[0] = 0;
        ver[m - 1] = w;
        for (int i = 0; i < verticalCuts.length; i++) {
            ver[i + 1] = verticalCuts[i];
        }

        long maxHeight = Long.MIN_VALUE;
        for (int i = 0; i <= hor.length - 2; i++) {
            maxHeight = Math.max(maxHeight, hor[i + 1] - hor[i]);
        }

        long maxWidth = Long.MIN_VALUE;
        for (int i = 0; i <= ver.length - 2; i++) {
            maxWidth = Math.max(maxWidth, ver[i + 1] - ver[i]);
        }

        return (int)((maxHeight % mod) * (maxWidth % mod) % mod);

    }
}