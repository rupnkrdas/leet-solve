class Solution {
    public List<List<Integer>> findPrimePairs(int n) {
        List<Integer> primes = getPrimes(n);
        List<List<Integer>> ans = new ArrayList<>();

        int left = 0;
        int right = primes.size() - 1;

        while (left <= right) {
            if (primes.get(left) + primes.get(right) == n) {
                List<Integer> pair = new ArrayList<>();
                pair.add(primes.get(left));
                pair.add(primes.get(right));
                ans.add(pair);
                left++;
                right--;
            } else if (primes.get(left) + primes.get(right) < n){
                left++;
            } else {
                right--;
            }
        }

        return ans;
    }

    public List<Integer> getPrimes(int n) {
        List<Integer> primes = new ArrayList<>();

        int[] check = new int[n + 1];
        for (int i = 2; i*i <= n; i++) {
            if (check[i] == 0) {
                for (int j = i*i; j <= n; j += i) {
                    check[j] = 1;
                }
            }
        }

        for (int i = 2; i < n; i++) {
            if(check[i] == 0) primes.add(i);
        }

        return primes;
    }
}