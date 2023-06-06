class Solution {
    public int kthFactor(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) list.add(i);
        }

        return (k - 1 < list.size()) ? list.get(k - 1) : -1;
    }
}