class Tuple implements Comparable<Tuple>{
    int first;
    int second;
    int third;

    public Tuple(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    @Override
    public int compareTo(Tuple t1) {
        int val = this.first - t1.first;
        if (val != 0) return val;
        else {
            return this.second - t1.second;
        }
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) return -1;
        int n = grid.length;
        if (grid[n - 1][n - 1] == 1) return -1;
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = (int)1e9;
            }
        }


        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        dist[0][0] = 1;
        pq.offer(new Tuple(1, 0, 0));
        while (!pq.isEmpty()) {
            Tuple tuple = pq.poll();
            int distance = tuple.first;
            int x = tuple.second;
            int y = tuple.third;

            for (int dx = -1; dx <= +1; dx++) {
                for (int dy = -1; dy <= +1; dy++) {
                    int ni = x + dx;
                    int nj = y + dy;
                    
                    if (ni >= 0 && ni < n
                       && nj >= 0 && nj < n
                       && grid[ni][nj] == 0) {
                        if (dist[ni][nj] > distance + 1) {
                            dist[ni][nj] = distance + 1;
                            pq.offer(new Tuple(dist[ni][nj], ni, nj));
                        }
                    }
                }
            }
        }

        return (dist[n - 1][n - 1] != (int)1e9) ? dist[n - 1][n - 1] : -1;
    }
}