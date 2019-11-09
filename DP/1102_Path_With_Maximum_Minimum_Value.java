class Solution {
    /*
    
    State: dp[i][j] is the maximum score of paths ended at position(i, j)

    dijkstra's algorithm
    
    Status: 0 -> unseen, 1 -> fringe, 2 -> in-tree
    
    */
    // private static final int UNSEEN = 0;
    // private static final int FRINGE = 1;
    // private static final int INTREE = -1;
    
    private static final int[] DIRECTION_X = new int[]{0, 1, 0, -1};
    private static final int[] DIRECTION_Y = new int[]{1, 0, -1, 0};
    
    public int maximumMinimumPath(int[][] A) {
        int m = A.length, n = A[0].length;
        int[][] dp = new int[m][n];
        boolean[][] isVisited = new boolean[m][n];
        
        // initialize
        dp[0][0] = A[0][0];
        
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        maxHeap.offer(new int[]{A[0][0], 0, 0});
        while (!maxHeap.isEmpty()) {
            int[] head = maxHeap.poll();
            isVisited[head[1]][head[2]] = true;
            
            if (head[1] == m-1 && head[2] == n-1) {
                // once in tree, it will not be modified again
                return dp[m-1][n-1];
            }
            
            for (int k = 0; k < 4; k++) {
                int x = head[1] + DIRECTION_X[k];
                int y = head[2] + DIRECTION_Y[k];
                
                if (x >= 0 && x < m && y >= 0 && y < n && !isVisited[x][y]) {
                    dp[x][y] = Math.max(Math.min(dp[head[1]][head[2]], A[x][y]), dp[x][y]);
                    maxHeap.offer(new int[]{A[x][y], x, y});
                }
            }
        }
        
        return -1;
    }
}