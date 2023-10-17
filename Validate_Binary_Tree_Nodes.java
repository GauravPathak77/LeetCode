class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            if (leftChild[i] >= 0 && !uf.union(i, leftChild[i])) {
                return false;
            }
            if (rightChild[i] >= 0 && !uf.union(i, rightChild[i])) {
                return false;
            }
        }
        return uf.components() == 1;
    }
}
class UnionFind {
    private final int n;
    private final int[] roots;
    private int components;
    
    UnionFind(int n) {
        this.n = n;
        roots = new int[n];
        for (int i = 0; i < n; i++) {
            roots[i] = i;
        }
        components = n;
    }
    
    public boolean union(int parent, int child) {
        int rootParent = findRoot(parent);
        int rootChild = findRoot(child);
        
        if (rootParent == rootChild || rootChild != child) {
            return false;
        }
        
        roots[rootChild] = rootParent;
        components--;
        return true;
    }
    
    private int findRoot(int v) {
        while (v != roots[v]) {
            roots[v] = roots[roots[v]];
            v = roots[v];
        }
        return v;
    }
    
    public int components() {
        return components;
    }
}
