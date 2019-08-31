package top.wumrwds;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 200. Number of Islands
 *
 * @author wumrwds
 */
public class Solution {

    private static class Point {
        int x;
        int y;

        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    /** define water and land */
    private static char LAND = '1';
    private static char WATER = '0';

    /** define direction arrays */
    private static int[] DIRECTION_X = {0, 1, 0, -1};
    private static int[] DIRECTION_Y = {1, 0, -1, 0};

    /**
     * Returns the number of islands.
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length, n = grid[0].length;
        Boolean[][] isVisited = new Boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                isVisited[i][j] = false;
            }
        }

        // traverse all connected blocks
        int[] cnt = new int[] {0};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == LAND && !isVisited[i][j]) {
                    traverseConnectedBlock(grid, new Point(i, j), isVisited, cnt);
                }
            }
        }

        return cnt[0];
    }

    /**
     * Traverses connected block by the given point.
     *
     * @param grid
     * @param point
     * @param isVisited
     * @param cnt
     */
    private void traverseConnectedBlock(char[][] grid, Point point, Boolean[][] isVisited, int[] cnt) {
        int m = grid.length, n = grid[0].length;

        // connected block count plus 1
        cnt[0]++;

        // bfs
        Queue<Point> bfsQueue = new LinkedList<>();
        bfsQueue.offer(point);

        while (!bfsQueue.isEmpty()) {
            Point head = bfsQueue.poll();

            // get neighbors of current head point
            List<Point> neighbors = getNeighbors(head, m, n);

            for (Point neighbor : neighbors) {
                if (isVisited[neighbor.x][neighbor.y]) {
                    continue;
                }

                // set this point as visited
                isVisited[neighbor.x][neighbor.y] = true;

                if (grid[neighbor.x][neighbor.y] == LAND) {
                    bfsQueue.offer(neighbor);
                }
            }
        }
    }

    private List<Point> getNeighbors(Point point, int m, int n) {
        List<Point> neighbors = new LinkedList<>();

        for (int i = 0; i < DIRECTION_X.length; i++) {
            int x = point.x + DIRECTION_X[i];
            int y = point.y + DIRECTION_Y[i];

            if (x >= 0 && x < m && y >= 0 && y < n) {
                neighbors.add(new Point(x, y));
            }
        }

        return neighbors;
    }
}