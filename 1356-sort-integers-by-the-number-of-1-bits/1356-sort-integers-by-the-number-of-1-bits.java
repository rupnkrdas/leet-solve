class Solution {
    private int fGetBits(int n) {
        int ans = 0;
        while (n > 0) {
            ans++;
            int rsbm = n & -n;
            n -= rsbm;
        }

        return ans;
    }
    public int[] sortByBits(int[] arr) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(arr);
        for (int num : arr) {
            list.add(new int[]{num, fGetBits(num)});
        }

        Collections.sort(list, (a, b) -> a[1] - b[1]);
        int[] res = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            res[i] = list.get(i)[0];
        }

        return res;
    }
}