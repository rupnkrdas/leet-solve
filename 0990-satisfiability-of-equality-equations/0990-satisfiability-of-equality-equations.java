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
    public boolean equationsPossible(String[] equations) {
        DS ds = new DS(26);
        for (String str : equations) {
            char[] arr = str.toCharArray();
            // arr[0] = 'c1', arr[1] = ('=' / '!'), arr[3] = 'c2'

            int c1 = arr[0] - 'a';
            int c2 = arr[3] - 'a';

            if (arr[1] == '!' && ds.find(c1) == ds.find(c2)) return false;
            if (ds.find(c1) != ds.find(c2) && arr[1] == '=') {
                ds.union(c1, c2);
            }
        }
        
        for (String str : equations) {
            char[] arr = str.toCharArray();
            // arr[0] = 'c1', arr[1] = ('=' / '!'), arr[3] = 'c2'

            int c1 = arr[0] - 'a';
            int c2 = arr[3] - 'a';

            if (arr[1] == '!' && ds.find(c1) == ds.find(c2)) return false;
        }

        return true;
    }
}