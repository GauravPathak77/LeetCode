class Solution {
    public class UnionFind {
        int[] parent, rank;
        int count;
            
        UnionFind(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];
            count = n;
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }
            
        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
            
        boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
                count--;
                return true;
            }
            return false;
        }
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        
        Arrays.sort(edges, (a, b) -> b[0] - a[0]);
        
        UnionFind ufA = new UnionFind(n);
        UnionFind ufB = new UnionFind(n);
        
        int edgesUsed = 0;
        
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                if (ufA.union(edge[1], edge[2])) {
                    ufB.union(edge[1], edge[2]);
                    edgesUsed++;
                }
            }
        }
        
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                if (ufA.union(edge[1], edge[2])) {
                    edgesUsed++;
                }
            } else if (edge[0] == 2) {
                if (ufB.union(edge[1], edge[2])) {
                    edgesUsed++;
                }
            }
        }
        
        if (ufA.count != 1 || ufB.count != 1) {
            return -1;
        }
        
        return edges.length - edgesUsed;
    }
}
