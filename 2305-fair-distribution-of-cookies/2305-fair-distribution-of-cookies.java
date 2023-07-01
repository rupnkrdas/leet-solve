class Solution {
    int[] children;
    public int solve(int index, int[] cookies, int k) {
        if (index == cookies.length) {
            int maxi = children[0];
            for (int num : children) {
                maxi = Math.max(maxi, num);
            }

            return maxi;
        }

        int mini = (int)(1e9);
        for (int i = 0; i < k; i++) {
            children[i] += cookies[index];
            int op = solve(index + 1, cookies, k);
            children[i] -= cookies[index];
            mini = Math.min(mini, op);
        }

        return mini;
    }
    public int distributeCookies(int[] cookies, int k) {
        children = new int[k];
        return solve(0, cookies, k);
    }
}