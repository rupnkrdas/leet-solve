class Solution {
    public String orderlyQueue(String s, int k) {
        // if k == 1: brute force
        // else sort the string
        if (k > 1) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            return new String(arr);
        } else {
            if (s.length() == 1) return s;
            String ans = s;
            String temp = s.substring(1) + s.charAt(0);
            while (!temp.equals(s)) {
                if (temp.compareTo(ans) < 0) ans = temp;
                temp = temp.substring(1) + temp.charAt(0);
            }

            return ans;
        }
    }
}