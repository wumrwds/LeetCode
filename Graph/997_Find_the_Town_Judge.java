class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] inDegrees = new int[N+1], outDegrees = new int[N+1];
        for (int[] edge : trust) {
            inDegrees[edge[1]]++;
            outDegrees[edge[0]]++;
        }
        
        for (int i = 1; i <= N; i++) {
            if (outDegrees[i] == 0 && inDegrees[i] == N-1) {
                return i;
            }
        }
        
        return -1;
    }
}