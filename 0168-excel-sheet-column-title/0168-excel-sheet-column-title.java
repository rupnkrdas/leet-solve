class Solution {
    public String convertToTitle(int columnNumber) {
        String res = "";
        int num = columnNumber;
        while (num > 0) {
            num--;
            int rem = num%26;
            char ch = (char)(rem + 'A');
            res = ch + res;
            num /= 26;
        }

        return res;
    }
}