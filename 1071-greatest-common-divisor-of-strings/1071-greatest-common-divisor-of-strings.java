class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int mini = Math.min(n, m);
        if (mini == n) {
            for (int i = n - 1; i >= 0; i--) {
                String substring = str2.substring(0, i + 1);
                int len = substring.length();

                if (n % len == 0 && m % len == 0) {
                    String s1 = "";
                    for (int j = 0; j < n / len; j++) {
                        s1 += substring;
                    }
                    String s2 = "";
                    for (int j = 0; j < m / len; j++) {
                        s2 += substring;
                    }
                    if (s1.equals(str1) && s2.equals(str2)) {
                        return substring;
                    }
                }
            }
        } else {
            for (int i = m - 1; i >= 0; i--) {
                String substring = str1.substring(0, i + 1);
                int len = substring.length();

                if (n % len == 0 && m % len == 0) {
                    String s1 = "";
                    for (int j = 0; j < n / len; j++) {
                        s1 += substring;
                    }
                    String s2 = "";
                    for (int j = 0; j < m / len; j++) {
                        s2 += substring;
                    }
                    if (s1.equals(str1) && s2.equals(str2)) {
                        return substring;
                    }
                }
            }
        }

        return "";
    }
}