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
     public boolean areSimilar(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) diff++;
        }

        return (diff == 2) || (diff == 0);
    }
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        DS ds = new DS(n);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (areSimilar(strs[i], strs[j])) {
                    ds.union(i, j);
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if(ds.find(i) == i) count++;
        }


        return count;
    }
}