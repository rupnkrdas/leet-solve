class Solution {
    public String addBinary(String a, String b) {
        char[] arr1 = a.toCharArray();
        char[] arr2 = b.toCharArray();

        int i = arr1.length - 1, j = arr2.length - 1, carry = 0;
        String res = "";

        while (i >= 0 || j >= 0) {
            int digit_a = (i >= 0) ? arr1[i--] - '0' : 0;
            int digit_b = (j >= 0) ? arr2[j--] - '0' : 0;

            int sum = digit_a + digit_b + carry;
            res = (Integer.toString(sum%2)) + res;
            carry = sum / 2;
        }

        if (carry == 1) {
            res = '1' + res;
        }

        return res;
    }

}