class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int m = difficulty.length, n = worker.length;
        int[][] pairs = new int[m][2];
        for (int i = 0; i < m; i++) {
            pairs[i] = new int[] {difficulty[i], profit[i]};
        }
        
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        Arrays.sort(worker);
        
        int sum = 0, max = 0;
        for (int i = 0, j = 0; i < n; i++) {
            while (j < m && pairs[j][0] <= worker[i]) {
                max = Math.max(max, pairs[j][1]);
                j++;
            }
            
            sum += max;
        }
        
        return sum;
    }
}