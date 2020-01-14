class Solution {
    private static int[] DIRECTION_X = new int[] {1, 0, -1, 0};
    private static int[] DIRECTION_Y = new int[] {0, -1, 0, 1};
    
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }
        
        int m = rooms.length, n = rooms[0].length;
        
        Queue<int[]> bfsQueue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    bfsQueue.offer(new int[]{i, j});
                }
            }
        }
        
        int dist = 0;
        while (!bfsQueue.isEmpty()) {
            dist++;
            int levelSize = bfsQueue.size();
            
            while (levelSize-- > 0) {
                int[] head = bfsQueue.poll();
                
                for (int k = 0; k < 4; k++) {
                    int x = head[0] + DIRECTION_X[k];
                    int y = head[1] + DIRECTION_Y[k];
                    
                    if (x >= 0 && x < m && y >= 0 && y < n && rooms[x][y] > 0 && dist < rooms[x][y]) {
                        rooms[x][y] = dist;
                        bfsQueue.offer(new int[]{x, y});
                    }
                }
            }
        }
    }
}