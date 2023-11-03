class Solution {
    public List<String> buildArray(int[] target, int n) {
        Set<Integer> set = new HashSet<>();
        for (int num : target) set.add(num);
        int last = target[target.length - 1];
        
        
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i > last) return res;
            if (set.contains(i)) res.add("Push");
            else {
                res.add("Push");
                res.add("Pop");
            }
        }

        return res;
    }
}