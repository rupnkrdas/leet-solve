class Node{
    int idx;
    int x;
    int y;

    public Node(int idx, int x, int y) {
        this.idx = idx;
        this.x = x;
        this.y = y;
    }
}

class Edge {
    Node u;
    Node v;
    int distance;

    public Edge(Node u, Node v, int distance) {
        this.u = u;
        this.v = v;
        this.distance = distance;
    }
}

class DS {
    int[] size;
    int[] parent;

    public DS(int n) {
        size = new int[n + 1];
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            size[i] = 1;
            parent[i] = i;
        }
    }

    public int find(int node) {
        if (node == parent[node]) return node;
        return parent[node] = find(parent[node]);
    }

    public void union(int u, int v) {
        int uu = find(u);
        int uv = find(v);

        if (uu == uv) return;

        if (size[uu] > size[uv]) {
            parent[uv] = uu;
            size[uu] += size[uv];
        } else {
            parent[uu] = uv;
            size[uv] += size[uu];
        }
    }
}

class Solution {
    public int minCostConnectPoints(int[][] points) {
        List<Node> list = new ArrayList<>();
        // O(n)
        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            Node node = new Node(i, x, y);
            list.add(node);
        }

        // O(n^2)
        List<Edge> adj = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                Node u = list.get(i);
                Node v = list.get(j);
                int distance = Math.abs(u.x - v.x) + Math.abs(u.y - v.y);

                adj.add(new Edge(u, v, distance));
            }
        }

        // (nlogn)
        Collections.sort(adj, (e1, e2) -> e1.distance - e2.distance);
        int n = list.size();
        DS ds = new DS(n);
        int cost = 0;
        // O(n * 4(alpha))
        for (Edge e : adj) {
            Node u = e.u;
            Node v = e.v;
            int distance = e.distance;

            if (ds.find(u.idx) != ds.find(v.idx)) {
                ds.union(u.idx, v.idx);
                cost += distance;
            }
        }

        return cost;
    }
} 