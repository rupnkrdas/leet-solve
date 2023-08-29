class Solution {
    public int bestClosingTime(String customers) {
        char[] arr = customers.toCharArray();
        int n = arr.length;
        int[] pre = new int[n + 1];
        int[] post = new int[n + 1];

        pre[0] = 0;
        post[n] = 0;
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1];
            if (arr[i-1]=='N') {
                pre[i]++;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            post[i] = post[i + 1];
            if (arr[i]=='Y') {
                post[i]++;
            }
        }

        int mini = Integer.MAX_VALUE;
        int idx = -1;
        for (int i = 0; i <= n; i++) {
            int pen = pre[i] + post[i];
            if (pen < mini) {
                mini = pen;
                idx = i;
            }
        }

        return idx;
    }
}