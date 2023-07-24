class Solution {
    public String mergeAlternately(String word1, String word2) {
        char[] arr = word1.toCharArray();
        char[] brr = word2.toCharArray();

        int i = 0, j = 0;
        String res = "";
        int turn = 0; // 0 for i, 1 for j
        while (i < word1.length() && j < word2.length()) {
            if (turn == 0) {
                res += arr[i];
                i++;
            } else {
                res += brr[j];
                j++;

            }

            turn = 1 - turn;
        }

        while (i < word1.length()) {
            res += arr[i++];
        }
        while (j < word2.length()) {
            res += brr[j++];
        }

        return res;
    }
}