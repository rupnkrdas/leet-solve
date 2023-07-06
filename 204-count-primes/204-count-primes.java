class Solution {
    public int countPrimes(int n) {
        int[] check = new int[n + 1];
        for (int i = 2; i*i <= n; i++) {
            if (check[i] == 0) {
                for(int j = i*i; j <= n; j += i) {
                    check[j] = 1;
                }
            }
        }

        int count = 0;
        // System.out.println(Arrays.toString(check));
        for (int i = 2; i < n; i++) {
            if (check[i] == 0) count++;
        }

        return count;
    }
}