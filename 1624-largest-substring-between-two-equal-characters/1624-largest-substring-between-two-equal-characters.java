class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int n = s.length();

        int[] start = new int[26]; // denotes the first index of each letter in the string
        Arrays.fill(start, -1);
        int[] end = new int[26]; // denotes the last index of each letter in the string
        Arrays.fill(end, -1);

        char[] arr = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if (start[arr[i]-'a'] == -1) {
                start[arr[i]-'a'] = i;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (end[arr[i]-'a'] == -1) {
                end[arr[i]-'a'] = i;
            }
        }

        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < 26; i++) {
            if (start[i] != -1 && end[i] != -1 && start[i] < end[i]) {
                maxi = Math.max(maxi, end[i] - start[i] - 1);
            }
        }

        return (maxi != Integer.MIN_VALUE) ? maxi : -1;
    }
}