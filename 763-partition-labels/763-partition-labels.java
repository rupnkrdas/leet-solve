class Solution {
    public List<Integer> partitionLabels(String s) {
        char[] a = s.toCharArray();
        int n = s.length();
        List<Integer> ans = new ArrayList<>();
        int[] last_index = new int[26];
        for (int i = 0; i < n; i++) {
            last_index[a[i] - 'a'] = i;
        }

        int start = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            end = Math.max(end, last_index[a[i] - 'a']);
            if (i == end) {
                ans.add(end - start + 1);
                start = end + 1;
            }
        }

        return ans;
    }
}