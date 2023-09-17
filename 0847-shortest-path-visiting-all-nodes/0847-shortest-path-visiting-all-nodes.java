class Tuple {
    int first;
    int second;
    int third;

    public Tuple(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    @Override
    public String toString() {
        return "[" + first + ", " + second +  ", " + third + "]";
    }
}
class Solution {
    int TARGET_MASK = 0;
    private int f(int node, int[][] graph) {
        Queue<Tuple> q = new LinkedList<>();
        Set<String> set = new HashSet<>();

        q.offer(new Tuple(node, (0 | (1 << node)), 0));
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                // System.out.println(set);
                Tuple t = q.poll();
                int node_ = t.first;
                int state = t.second;
                int steps = t.third;

                if (state == TARGET_MASK) return steps;

                for (int adjNode : graph[node_]) {
                    String s = Integer.toString(adjNode) + "," + Integer.toString(state | (1 << adjNode));
                    if (!set.contains(s)) {
                        set.add(s);
                        q.offer(new Tuple(adjNode, state | (1 << adjNode), steps+1));
                    }
                }
            }
        }

        return -1;
    }
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        TARGET_MASK = (int)Math.pow(2, n) - 1;
        System.out.println(Integer.toBinaryString(TARGET_MASK));  
        int mini = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int minFromNode = f(i, graph);
            // System.out.println(minFromNode);
            mini = Math.min(mini, minFromNode);
        }

        return mini;
    }
}