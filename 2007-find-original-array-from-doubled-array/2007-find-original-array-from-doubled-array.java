class Solution {
    public int[] findOriginalArray(int[] nums) {
        int n = nums.length;
        if (n % 2 != 0) return new int[]{};
        
        Arrays.sort(nums);
        Map<Double, Integer> map = new HashMap<>();

        List<Integer> list = new ArrayList<>();
        
        for (int num : nums) {
            double half = (double)num/2;
            // System.out.println(map);
            
            if (map.containsKey(half)) {
                list.add((int)half);
                map.put(half, map.get(half) - 1);
                if (map.get(half) == 0) map.remove(half);
            } else {
                map.put((double)num, map.getOrDefault((double)num, 0) + 1);
            }
        }
        // System.out.println(map);

        return (map.size() == 0) ? list.stream().mapToInt(Integer::intValue).toArray() : new int[]{};
    }
}