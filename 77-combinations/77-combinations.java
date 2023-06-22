class Solution {
    public List<List<Integer>> combine(int n, int k) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        List<List<Integer>> ans = new ArrayList<>();
        solve(0, new ArrayList<>(), ans, arr, k);

        return ans;
    }

    public void solve(int i, List<Integer> list, List<List<Integer>> ans, int[] arr, int k) {
        if (list.size() == k) {
            ans.add(new ArrayList<>(list));
            return;
        }

        if (i == arr.length) {
            return;
        }


        list.add(arr[i]);
        solve(i + 1, list, ans, arr, k);
        list.remove(list.size() - 1);
        solve(i + 1, list, ans, arr, k);
    }
}