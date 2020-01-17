class Solution {
    private static int[] DIRECTION_X = new int[] {-1, 0, 1, 0};
    private static int[] DIRECTION_Y = new int[] {0, 1, 0, -1};
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image;
        }
        
        setColor(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
    
    private void setColor(int[][] image, int i, int j, int color, int newColor) {
        int m = image.length, n = image[0].length;
        image[i][j] = newColor;
        for (int k = 0; k < 4; k++) {
            int x = i + DIRECTION_X[k], y = j + DIRECTION_Y[k];
            
            if (x >= 0 && x < m && y >= 0 && y < n && image[x][y] == color) {
                setColor(image, x, y, color, newColor);
            }
        }
    }
}