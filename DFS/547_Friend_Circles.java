class Solution {
    
    public int findCircleNum(int[][] M) {
        int n = M.length;
        
        // WHITE -> 0, GREY -> 1, BLACK = 2
        int[] color = new int[n];
        
        int scc = 0;
        for (int i = 0; i < n; i++) {
            if (color[i] == 0) {
                scc++;
                dfs(M, i, color);
            }
        }
        
        return scc;
    }
    
    private void dfs(int[][] M, int i, int[] color) {
        color[i] = 1;
        
        for (int j = 0; j < M.length; j++) {
            if (j != i && M[i][j] == 1 && color[j] == 0) {
                dfs(M, j, color);
            }
        }
        
        color[i] = 2;
    }
}