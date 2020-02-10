class Solution {
    private class UnionFind {
        private int[] parent;
        private int[] rank;
        
        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            
            for (int i = 0; i < n; i++) {
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
        
        private void link(int x, int y) {
            if (rank[x] < rank[y]) {
                // x -> y
                parent[x] = y;
            }
            else {
                // x <- y
                parent[y] = x;
                
                if (rank[x] == rank[y]) {
                    rank[x]++;
                }
            }
        }
        
        public void union(int x, int y) {
            link(find(x), find(y));
        }
    }
    
    public String smallestEquivalentString(String A, String B, String S) {
        int n = A.length();
        
        // make set then union
        UnionFind uf = new UnionFind(26);
        for (int i = 0; i < n; i++) {
            char ch1 = A.charAt(i), ch2 = B.charAt(i);
            uf.union(ch1 - 'a', ch2 - 'a');
        }
        
        // find the lexicographically smallest for each letter 
        Character[] smallestDict = new Character[26], setSmallest = new Character[26];
        for (int i = 0; i < 26; i++) {
            int set = uf.find(i);
            if (setSmallest[set] == null) {
                setSmallest[set] = (char) ('a' + i);
                smallestDict[i] = (char) ('a' + i);
            }
            else {
                smallestDict[i] = setSmallest[set];
            }
        }
        
        StringBuilder res = new StringBuilder();
        for (char ch : S.toCharArray()) {
            res.append(smallestDict[ch - 'a']);
        }
        return res.toString();
    }
}


class Solution {
    public String smallestEquivalentString(String A, String B, String S) {
        int[] graph = new int[26];
        for(int i = 0; i < 26; i++) {
            graph[i] = i;
        }
        for(int i = 0; i < A.length(); i++) {
            int a = A.charAt(i) - 'a';
            int b = B.charAt(i) - 'a';
            int end1 = find(graph, b);
            int end2 = find(graph, a);
            if(end1 < end2) {
                graph[end2] = end1;
            } else {
                graph[end1] = end2;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            sb.append((char)('a' + find(graph, c - 'a')));
        }
        return sb.toString();
    }
    
    private int find(int[] graph, int idx) {
        while(graph[idx] != idx) {
            idx = graph[idx];
        }
        return idx;
    }
}