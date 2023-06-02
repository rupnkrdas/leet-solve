class Solution {
    long mod = (long) (1e9 + 7);
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        long[] nsl1 = findNSL(horizontalCuts);
        long[] ngr1 = findNGR(horizontalCuts, h);
        long[] nsl2 = findNSL(verticalCuts);
        long[] ngr2 = findNGR(verticalCuts, w);

        // System.out.println(Arrays.toString(nsl1));
        // System.out.println(Arrays.toString(ngr1));
        // System.out.println(Arrays.toString(nsl2));
        // System.out.println(Arrays.toString(ngr2));

        long maxHeight = Integer.MIN_VALUE;
        for (int i = 0; i < nsl1.length; i++) {
            maxHeight = Math.max(maxHeight, horizontalCuts[i] - nsl1[i]) % mod;
        }
        for (int i = 0; i < ngr1.length; i++) {
            maxHeight = Math.max(maxHeight, ngr1[i] - horizontalCuts[i]) % mod;
        }

        long maxWidth = Integer.MIN_VALUE;
        for (int i = 0; i < nsl2.length; i++) {
            maxWidth = Math.max(maxWidth, verticalCuts[i] - nsl2[i]) % mod;
        }
        for (int i = 0; i < ngr2.length; i++) {
            maxWidth = Math.max(maxWidth, ngr2[i] - verticalCuts[i]) % mod;
        }

        return (int) (maxHeight % mod * maxWidth % mod);
    }

    public long[] findNGR(int[] arr, long right) {
        int n = arr.length;
        long[] ans = new long[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            if (st.isEmpty()) {
                ans[i] = right;
            } else {
                if (st.peek() > arr[i]) {
                    ans[i] = st.peek();
                } else {
                    while (!st.isEmpty() && st.peek() <= arr[i]) {
                        st.pop();
                    }
                    if (st.isEmpty()) {
                        ans[i] = right;
                    } else {
                        ans[i] = st.peek();
                    }
                }
            }

            st.push(arr[i]);
        }

        return ans;
    }
    
    public long[] findNSL(int[] arr) {
        int n = arr.length;
        long[] ans = new long[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (st.isEmpty()) {
                ans[i] = 0;
            } else {
                if (st.peek() < arr[i]) {
                    ans[i] = st.peek();
                } else {
                    while (!st.isEmpty() && st.peek() >= arr[i]) {
                        st.pop();
                    }
                    if (st.isEmpty()) {
                        ans[i] = 0;
                    } else {
                        ans[i] = st.peek();
                    }
                }
            }

            st.push(arr[i]);
        }

        return ans;
    }
}