class Solution {
    
    private static int[] DIRECTION_X = new int[] {-1, 0, 1, 0};
    private static int[] DIRECTION_Y = new int[] {0, 1, 0, -1};
    
    public int orangesRotting(int[][] grid) {
        int fresh = 0, minutes = 0, m = grid.length, n = grid[0].length;
        
        // count the number of fresh oranges, find all the rotten oranges
        Queue<int[]> bfsQueue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                }
                else if (grid[i][j] == 2) {
                    for (int k = 0; k < 4; k++) {
                        int x = i + DIRECTION_X[k];
                        int y = j + DIRECTION_Y[k];

                        if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                            bfsQueue.offer(new int[] {x, y});
                        }
                    }
                }
            }
        }
        
        if (fresh == 0) {
            return minutes;
        }
        
        while (!bfsQueue.isEmpty()) {
            int size = bfsQueue.size();
            minutes++;
            
            for (int k = 0; k < size; k++) {
                int[] head = bfsQueue.poll();
                
                if (grid[head[0]][head[1]] != 1) {
                    continue;
                }
                
                if (--fresh == 0) {
                    return minutes;
                }

                // mark as visited
                grid[head[0]][head[1]] = 3;

                for (int i = 0; i < 4; i++) {
                    int x = head[0] + DIRECTION_X[i];
                    int y = head[1] + DIRECTION_Y[i];

                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                        bfsQueue.offer(new int[] {x, y});
                    }
                }
            }
        }
        
        return -1;
    }
}