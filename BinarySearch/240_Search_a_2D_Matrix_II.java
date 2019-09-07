class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length, n = matrix[0].length;

        // iterate from the left bottom conner; matrix[x][y] is the mid of the L-shaped array
        int x = m - 1, y = 0;
        while (x >= 0 && y <= n - 1) {
            if (target == matrix[x][y]) {
                return true;
            }
            else if (target < matrix[x][y]) {
                x--;
            }
            else {
                y++;
            }
        }

        return false;
    }
}