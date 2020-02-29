class Solution {
    private class UnionFind {
        private int[] parent;
        private int[] rank;
        private int count;
        
        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            count = n;
            
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }
        
        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            
            return parent[x];
        }
        
        private void link(int x, int y) {
            if (rank[x] < rank[y]) {
                parent[x] = y;
            }
            else {
                if (rank[x] == rank[y]) {
                    rank[x]++;
                }
                
                parent[y] = x;
            }
        }
        
        public void union(int x, int y) {
            if (x < 0 || y < 0) {
                return;
            }
            
            int g1 = find(x), g2 = find(y);
            if (g1 != g2) {
                count--;
            }
            
            link(g1, g2);
        }
    }
    
    /*
    mapping: 4n*i + 4*j + t
    
     0
    3\/1
     /\
     2
    
    */
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        UnionFind uf = new UnionFind(4*n*n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i].charAt(j) == '/') {
                    uf.union(mapping(i, j, 0, n), mapping(i, j, 3, n));
                    uf.union(mapping(i, j, 1, n), mapping(i, j, 2, n));
                }
                else if (grid[i].charAt(j) == '\\') {
                    uf.union(mapping(i, j, 0, n), mapping(i, j, 1, n));
                    uf.union(mapping(i, j, 2, n), mapping(i, j, 3, n));
                }
                else {
                    uf.union(mapping(i, j, 0, n), mapping(i, j, 1, n));
                    uf.union(mapping(i, j, 1, n), mapping(i, j, 2, n));
                    uf.union(mapping(i, j, 2, n), mapping(i, j, 3, n));
                }
                
                uf.union(mapping(i, j, 0, n), mapping(i-1, j, 2, n));
                uf.union(mapping(i, j, 3, n), mapping(i, j-1, 1, n));
            }
        }
        
        return uf.count;
    }
    
    private static int mapping(int i, int j, int t, int n) {
        if (i >= 0 && i < n && j >= 0 && j < n) {
            return 4*n*i + 4*j + t;
        }
        
        return -1;
    }
}