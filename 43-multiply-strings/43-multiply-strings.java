class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        String mini = num1;
        String other = num2;
        if (num2.length() < mini.length()) {
            mini = num2;
            other = num1;
        }

        String res = "0";
        for(int i = mini.length() - 1; i >= 0; i--) {
            String product = mul(other, mini.charAt(i));
            res = add(product, res);
            System.out.println(other);
            other += '0';
        }

        return res;
    }

    public String add(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        int i = n1-1;
        int j = n2-1;
        String res = "";
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int d1 = (i >= 0) ? num1.charAt(i--) - '0': 0;
            int d2 = (j >= 0) ? num2.charAt(j--) - '0': 0;
            int sum = d1 + d2 + carry;
            res = Integer.toString(sum%10) + res;
            carry = sum / 10;
        }

        if (carry != 0) {
            res = Integer.toString(carry) + res;
        }
        
        return res;
    }

    public String mul(String num, char c) {
        String res = "";
        int n = num.length();
        int carry = 0;
        for (int i = n - 1; i >= 0; i--) {
            int product = (num.charAt(i) - '0') * (c - '0') + carry;
            res = Integer.toString(product % 10) + res;
            carry = product / 10;
        }

        if (carry != 0) {
            res = Integer.toString(carry) + res;
        }

        return res;
    }
}