class Solution {
    public String addBinary(String a, String b) {
        a = reverse(a);
        b = reverse(b);

        int carry = 0;
        String res = "";
        for (int i = 0; i < Math.max(a.length(), b.length()); i++) {
            int digit_a = (i < a.length()) ? a.charAt(i) - '0' : 0;
            int digit_b = (i < b.length()) ? b.charAt(i) - '0' : 0;

            int total = digit_a + digit_b + carry;
            res += Integer.toString(total % 2);
            carry = total / 2;
        }

        if (carry == 1) res += '1';

        return reverse(res);
    }

    public String reverse(String s) {
        String rev = "";
        int n = s.length();
        for (int i = n - 1; i >= 0; i--) {
            rev += s.charAt(i);
        }

        return rev;
    }
}