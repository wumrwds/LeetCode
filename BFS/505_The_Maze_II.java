class Solution {
    private static int[] DIRECTION_X = new int[] {1, 0, -1, 0};
    private static int[] DIRECTION_Y = new int[] {0, 1, 0, -1};
    
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        
        Queue<int[]> bfsQueue = new LinkedList<>();
        for (int k = 0; k < 4; k++) {
            int x = start[0] + DIRECTION_X[k], y = start[1] + DIRECTION_Y[k];
            
            if (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] != 1) {
                bfsQueue.offer(new int[] {x, y, k});
            }
        }
        
        int distance = 1;
        boolean[][] isStopPoint = new boolean[m][n];
        while (!bfsQueue.isEmpty()) {
            int levelSize = bfsQueue.size();
            
            while (levelSize-- > 0) {
                int[] head = bfsQueue.poll();
                
                int x = head[0] + DIRECTION_X[head[2]], y = head[1] + DIRECTION_Y[head[2]];
                if (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] != 1) {
                    bfsQueue.offer(new int[] {x, y, head[2]});
                }
                else if (isStopPoint[head[0]][head[1]] == false) {
                    isStopPoint[head[0]][head[1]] = true;

                    if (head[0] == destination[0] && head[1] == destination[1]) {
                        return distance;
                    }

                    for (int k = 0; k < 4; k++) {
                        if (k != head[2]) {
                            x = head[0] + DIRECTION_X[k]; 
                            y = head[1] + DIRECTION_Y[k];

                            if (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] != 1) {
                                bfsQueue.offer(new int[] {x, y, k});
                            }
                        }
                    }
                }
            }
            
            distance++;
        }
        
        return -1;
    }
}