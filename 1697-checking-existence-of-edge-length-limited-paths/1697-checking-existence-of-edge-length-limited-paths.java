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
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        DS ds = new DS(n);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            int t = queries[i][2];
            list.get(i).add(u);
            list.get(i).add(v);
            list.get(i).add(t);
            list.get(i).add(i);
        }

        Collections.sort(list, new Comparator<List<Integer>>(){
            public int compare(List<Integer> l1, List<Integer> l2) {
                return l1.get(2) - l2.get(2);
            };
        });

        Arrays.sort(edgeList, ((e1, e2) -> e1[2] - e2[2]));

        boolean[] res = new boolean[list.size()];
        int j = 0;
        for (int i = 0; i < list.size(); i++) {
            int u = list.get(i).get(0);
            int v = list.get(i).get(1);
            int t = list.get(i).get(2);
            int index = list.get(i).get(3);

            while (j < edgeList.length && edgeList[j][2] < t) {
                ds.union(edgeList[j][0], edgeList[j][1]);
                j++;
            }
            if (ds.find(u) == ds.find(v)) res[index] = true;
        }

        return res;
    }












}