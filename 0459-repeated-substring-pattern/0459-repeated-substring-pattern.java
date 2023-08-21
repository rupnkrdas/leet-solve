class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for (int j = len/2; j >= 1; j--) {
            if (len%j == 0) {
                String s_ = s.substring(0, j);
                int times = len/j;
                String str = "";
                while (times-- > 0) {
                    str += s_;
                }

                if (str.equals(s)) return true;
            }
        }

        return false;
    }
}