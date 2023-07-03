class Solution {
    public int bs(List<Integer> list, int target) {
        int start = 0;
        int end = list.size() - 1;

        int index = -1;
        while (start <= end) {
            int mid = start + (end - start)/2;

            if (list.get(mid) < target) {
                index = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return index;
    }
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 101; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] rec : rectangles) {
            int x = rec[0];
            int y = rec[1];

            list.get(y).add(x);
        }
        for (List<Integer> l : list) {
            Collections.sort(l);
        }

        int[] res = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            int count = 0;
            int x_ = points[i][0];
            int y_ = points[i][1];

            for (int j = y_; j < 101; j++) {
                List<Integer> rectangle_with_height_j = list.get(j);
                int index = bs(rectangle_with_height_j, x_);
                count += rectangle_with_height_j.size() - index - 1;
            }

            res[i] = count;
        }

        return res;

    }
}