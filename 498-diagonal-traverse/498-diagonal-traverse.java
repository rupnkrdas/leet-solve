class Solution {
    public int[] findDiagonalOrder(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        Map<Integer, LinkedList<Integer>> map = new TreeMap<>();
        List<Integer> ans = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int key = i + j;
                if ((key & 1) > 0) { // odd
                    if (map.containsKey(key)) {
                        LinkedList<Integer> list = map.get(key);
                        list.addLast(grid[i][j]);
                    } else {
                        LinkedList<Integer> list = new LinkedList<>();
                        list.addLast(grid[i][j]);
                        map.put(key, list);
                    }
                } else { // even
                    if (map.containsKey(key)) {
                        LinkedList<Integer> list = map.get(key);
                        list.addFirst(grid[i][j]);
                    } else {
                        LinkedList<Integer> list = new LinkedList<>();
                        list.addFirst(grid[i][j]);
                        map.put(key, list);
                    }
                }
            }
        }

        for (List<Integer> list : map.values()) {
            ans.addAll(list);
        }

        int[] result = ans.stream().mapToInt(Integer::intValue).toArray();
        return result;
    }
}