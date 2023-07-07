class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int[] freq = {0, 0}; // 0 -> T, 1 --> F
        char[] str = answerKey.toCharArray();

        int i = 0, j = 0, n = str.length;
        int maxi = 1;

        while (j < n) {
            char c = str[j];
            if (c == 'T') freq[0]++;
            else freq[1]++;

            if (find_min(freq) <= k) {
                maxi = Math.max(maxi, j - i + 1);
            }
            else if (find_min(freq) > k) {
                while (find_min(freq) > k) {
                    char ch = str[i];
                    if (ch == 'T') freq[0]--;
                    else freq[1]--;
                    i++;
                }
            }

            j++;
        }

        return maxi;
    }

    private int find_min(int[] arr) {
        int min = Arrays.stream(arr).min().getAsInt();
        return min;
    }
    private int find_max(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        return max;
    }
}