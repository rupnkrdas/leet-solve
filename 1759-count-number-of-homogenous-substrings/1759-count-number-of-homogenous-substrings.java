class Solution {
    private int MOD = (int)(1e9 + 7);
    public int countHomogenous(String s) {
        int N = s.length();
        if (N == 1) return 1;

        char[] arr = s.toCharArray();
        long len = 1;
        char last = arr[0];
        long res = 0;
        for (int i = 1; i < N; i++) {
            if (arr[i] == arr[i - 1]) {
                len++;
            } else {
                res = res%MOD + (len%MOD * (len%MOD + 1)%MOD)/2;
                len = 1;
            }
            // System.out.println(arr[i] + ": " + len + " res : " + res);  
        }

        return (int)(res%MOD + (len%MOD * (len + 1)%MOD)%MOD/2);
    }
}