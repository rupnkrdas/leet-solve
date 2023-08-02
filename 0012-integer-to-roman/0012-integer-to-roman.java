class Solution {
    public String intToRoman(int num) {
        int[] val = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] arr = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        String res = "";

        for (int i = 0; i < 13; i++) {
            int times = num/val[i];
            while (times-- > 0) {
                res += arr[i];
            }

            num %= val[i];
        }

        return res;
    }
}