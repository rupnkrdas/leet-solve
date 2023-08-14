class Solution {
    List<Integer> ans = new ArrayList<>();
    private void f(int curr, int n) {
        if (curr > n) return;

        ans.add(curr);
        for (int i = 0; i <= 9; i++) {
            if (curr * 10 + i <= n) {
                f(curr * 10 + i, n);
            }
        }
    }
    public List<Integer> lexicalOrder(int n) {
        for (int i = 1; i <= 9; i++) {
            f(i, n);
        }

        return ans;
    }
}