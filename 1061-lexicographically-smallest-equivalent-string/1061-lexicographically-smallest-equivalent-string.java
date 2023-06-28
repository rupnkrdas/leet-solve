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

        // if (size[uu] >= size[uv]) {
        //     parent[uv] = uu;
        //     size[uu] += size[uv];
        // } else {
        //     parent[uu] = uv;
        //     size[uv] += size[uu];
        // }
        if (uu < uv) {
            parent[uv] = uu;
            size[uu]++;
        } else {
            parent[uu] = uv;
            size[uv]++;
        }
    }
}
class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int n = s1.length();
        DS ds = new DS(26);
        for (int i = 0; i < n; i++) {
            int c1 = s1.charAt(i) - 'a';
            int c2 = s2.charAt(i) - 'a';
            // keep c1 smaller
            if (c1 > c2) {
                int temp = c1;
                c1 = c2;
                c2 = temp;
            }
            ds.union(c1, c2);
        }

        char[] arr = baseStr.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char)(ds.find(arr[i]-'a') + 'a');
        }

        return new String(arr);
    }
}