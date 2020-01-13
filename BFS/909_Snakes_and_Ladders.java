class Solution {
    public int snakesAndLadders(int[][] board) {
        int m = board.length, n = board[0].length, end = m*n;
        
        Queue<Integer> bfsQueue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        bfsQueue.offer(1);
        
        int steps = 0;
        while (!bfsQueue.isEmpty()) {
            int levelSize = bfsQueue.size();
            steps++;
            
            for (int i = 0; i < levelSize; i++) {
                Integer head = bfsQueue.poll();
                
                for (int k = 1; k <= 6; k++) {
                    int nextStep = head + k;
                    int[] cur = getCoord(m, n, nextStep);

                    if (board[cur[0]][cur[1]] > 0) {
                        nextStep = board[cur[0]][cur[1]];
                    }

                    if (nextStep == end) {
                        return steps;
                    }
                    
                    if (visited.contains(nextStep)) {
                        continue;
                    }
                    
                    visited.add(nextStep);
                    bfsQueue.offer(nextStep);
                }
            }
        }
        
        return -1;
    }
    
    private int[] getCoord(int m, int n, int i) {
        int rows = (i-1) / n, cols = (i-1) % n;
        
        if (rows % 2 == 0) {
            // even rows
            return new int[]{m-1-rows, cols};
        }
        else {
            return new int[]{m-1-rows, n-1-cols};
        }
    }    
}