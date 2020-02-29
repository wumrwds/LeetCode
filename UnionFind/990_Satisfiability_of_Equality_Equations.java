class Solution {
    private class UnionFind {
        private int[] rank;
        private int[] parent;
        
        UnionFind(int n) {
            rank = new int[26];
            parent = new int[26];
            
            for (int i = 0; i < 26; i++) {
                rank[i] = 1;
                parent[i] = i;
            }
        }
        
        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            
            return parent[x];
        }
        
        private void link(int a, int b) {
            if (rank[a] < rank[b]) {
                parent[a] = b;
            }
            else {
                if (rank[a] == rank[b]) {
                    rank[a]++;
                }
                
                parent[b] = a;                
            }
        }
        
        public void union(int x, int y) {
            link(find(x), find(y));
        }
    }
    
    public boolean equationsPossible(String[] equations) {
        UnionFind uf = new UnionFind(26);
        
        for (String equation : equations) {
            int v1 = equation.charAt(0) - 'a', v2 = equation.charAt(3) - 'a';
            
            if (equation.charAt(1) == '=') {
                uf.union(v1, v2);
            }
        }
        
        for (String equation : equations) {
            int v1 = equation.charAt(0) - 'a', v2 = equation.charAt(3) - 'a';
            
            if (equation.charAt(1) == '!' && uf.find(v1) == uf.find(v2)) {
                return false;
            }
        }
        
        return true;
    }
}