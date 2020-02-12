class Solution {
    public boolean judgeSquareSum(int c) {
        int maxNum = (int) Math.floor(Math.sqrt(c));
        int[] squares = new int[maxNum + 1];
        for (int i = 0; i <= maxNum; i++) {
            squares[i] = i * i;
        }
        
        int start = 0, end = maxNum;
        while (start <= end) {
            if (squares[start] + squares[end] == c) {
                return true;
            }
            else if (squares[start] + squares[end] > c) {
                end--;
            }
            else {
                start++;
            }
        }
        
        return false;
    }
}