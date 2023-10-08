class Solution {
    public int minProcessingTime(List<Integer> p, List<Integer> t) {
        // 20 10
        // 1 2 2 3 3 4 5 8
        Collections.sort(p, Collections.reverseOrder());
        Collections.sort(t);

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < t.size(); i+=4) {
            List<Integer> sub = t.subList(i, i + 4);
            list.add(sub);
        }

        int maxTime = 0;
        for (int i = 0; i < p.size(); i++) {
            int maxi = Integer.MIN_VALUE;
            for (int num : list.get(i)) maxi = Math.max(maxi, num);
            maxTime = Math.max(maxTime, maxi + p.get(i));
        }
        
        return maxTime;
    }
}