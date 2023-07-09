class Solution {
    public int largestVariance(String s) {
        char[] arr = s.toCharArray();
        int[] present_in_s = new int[26];
        for (char c : arr) {
            present_in_s[c - 'a'] = 1;
        }

        int result = 0;

        for (char first = 'a'; first <= 'z'; first++) {
            for (char second = 'a'; second <= 'z'; second++) {
                if (present_in_s[first - 'a'] == 0 || present_in_s[second - 'a'] == 0) continue;
                
                int first_count     = 0; // F1
                int second_count    = 0; // F2
                boolean second_found_earlier = false;

                for (char ch : arr) {
                    if (ch == first) first_count++;
                    if (ch == second) second_count++;

                    if (second_count > 0) result = Math.max(result, first_count - second_count);
                    else { // second_count == 0
                        if (second_found_earlier) result = Math.max(result, first_count - 1);
                    }

                    if (second_count > first_count) {
                        first_count = 0;
                        second_count = 0;
                        second_found_earlier = true;
                    }
                }
            }
        }

        return result;
    }
}