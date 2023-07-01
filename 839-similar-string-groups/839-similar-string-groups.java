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
     public boolean areStringsSimilar(String X, String Y) {
        if (X.equals(Y)) {
            return true; // X and Y are identical
        }
        
        if (X.length() != Y.length()) {
            return false; // X and Y have different lengths, not similar
        }
        
        int firstMismatch = -1;
        int secondMismatch = -1;
        
        for (int i = 0; i < X.length(); i++) {
            if (X.charAt(i) != Y.charAt(i)) {
                if (firstMismatch == -1) {
                    firstMismatch = i;
                } else if (secondMismatch == -1) {
                    secondMismatch = i;
                } else {
                    return false; // More than two mismatches, not similar
                }
            }
        }
        
        return (secondMismatch != -1 && X.charAt(firstMismatch) == Y.charAt(secondMismatch)
                && X.charAt(secondMismatch) == Y.charAt(firstMismatch));
    }
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        DS ds = new DS(n);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (areStringsSimilar(strs[i], strs[j])) {
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