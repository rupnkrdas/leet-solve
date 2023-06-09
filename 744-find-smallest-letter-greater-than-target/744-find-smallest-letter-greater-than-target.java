class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target >= letters[mid]) start = mid + 1;
            else {
                end = mid - 1;
            }
        }

        return letters[start%n];
    }
}