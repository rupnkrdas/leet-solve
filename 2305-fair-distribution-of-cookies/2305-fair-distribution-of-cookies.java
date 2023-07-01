class Solution {
    int[] children;
    int res = (int)1e9;
    public void solve(int index, int[] cookies, int k) {
        if (index == cookies.length) {
            int maxi = children[0];
            for (int num : children) {
                maxi = Math.max(maxi, num);
            }

            res = Math.min(res, maxi);
            return;
        }

        for (int i = 0; i < k; i++) {
            children[i] += cookies[index];
            solve(index + 1, cookies, k);
            children[i] -= cookies[index];
        }
    }
    public int distributeCookies(int[] cookies, int k) {
        children = new int[k];
        solve(0, cookies, k);
        return res;
    }
}