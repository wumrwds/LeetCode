class Solution {
    
    private static int[] DIRECTION_X = new int[]{-1, 0, 1, 0};
    private static int[] DIRECTION_Y = new int[]{0, 1, 0, -1};
    
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        
        int[][] ans = new int[m][n];
        Queue<int[]> bfsQueue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    bfsQueue.offer(new int[]{i, j});
                }
                else {
                    ans[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        int distance = 1;
        while (!bfsQueue.isEmpty()) {
            int size = bfsQueue.size();
            
            while (size-- > 0) {
                int[] head = bfsQueue.poll();
                int x = head[0], y = head[1];
                
                // System.out.println(x + ", " + y);
                
                for (int k = 0; k < 4; k++) {
                    int i = x + DIRECTION_X[k], j = y + DIRECTION_Y[k];
                    
                    if (i >= 0 && i < m && j >= 0 && j < n && matrix[i][j] != 0 && distance < ans[i][j]) {
                        ans[i][j] = distance;
                        bfsQueue.offer(new int[]{i, j});
                    }
                }
            }
            
            distance++;
        }
        
        return ans;
    }
}