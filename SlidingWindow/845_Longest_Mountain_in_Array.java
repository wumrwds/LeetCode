class Solution {
    public int longestMountain(int[] A) {
        int n = A.length, p = 0, q = 0, maxLen = 0;
        
        boolean asc = true;
        while (q < n - 1) {
            boolean isAsc = false, isDesc = false;
            while (asc && q+1 < n && A[q] < A[q+1]) {
                isAsc = true;
                q++;
            }
            asc = false;
            
            while (!asc && q+1 < n && A[q] > A[q+1]) {
                isDesc = true;
                q++;
            }
            asc = true;
            
            // System.out.println(p + ", " + q + ", " + maxLen);
            
            if (q - p + 1 >= 3 && isAsc && isDesc) {
                maxLen = Math.max(q - p + 1, maxLen);
            }
            
            while (q+1 < n && A[q] == A[q+1]) {
                q++;
            }
            p = q;
        }
            
        return maxLen;
    }
}