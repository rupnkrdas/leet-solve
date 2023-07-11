class Solution {
    public int[][] diagonalSort(int[][] nums) {
        //top-left to bottom-right: [i - j] technique
        int n = nums.length, m = nums[0].length;
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int key = i - j;
                if (map.containsKey(key)) {
                    LinkedList<Integer> list = map.get(key);
                    list.addLast(nums[i][j]);
                } else {
                    LinkedList<Integer> list = new LinkedList<>();
                    list.addLast(nums[i][j]);
                    map.put(key, list);
                }
            }
        }

        for (LinkedList<Integer> list : map.values()) {
            Collections.sort(list);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int key = i - j;
                LinkedList<Integer> list = map.get(key);
                nums[i][j] = list.removeFirst();
            }
        }

        return nums;
    }
}