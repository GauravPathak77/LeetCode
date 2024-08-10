class Solution {
    public int regionsBySlashes(String[] grid) {
         int n = grid.length;
        int totalRegions = 4 * n * n;
        UnionFind uf = new UnionFind(totalRegions);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int index = 4 * (i * n + j);
                char val = grid[i].charAt(j);
                
                if (val == '/') {
                    uf.union(index, index + 3);
                    uf.union(index + 1, index + 2);
                } else if (val == '\\') {
                    uf.union(index, index + 1);
                    uf.union(index + 2, index + 3);
                } else {
                    uf.union(index, index + 1);
                    uf.union(index + 1, index + 2);
                    uf.union(index + 2, index + 3);
                }
                
                if (j + 1 < n) {
                    uf.union(index + 1, 4 * (i * n + (j + 1)) + 3);
                }
                
                if (i + 1 < n) {
                    uf.union(index + 2, 4 * ((i + 1) * n + j));
                }
            }
        }

        return uf.getCount();
    }

    class UnionFind {
        private int[] parent;
        private int count;

        public UnionFind(int n) {
            parent = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootX] = rootY;
                count--;
            }
        }

        public int getCount() {
            return count;
        }
    }
}
