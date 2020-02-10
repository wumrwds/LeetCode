class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        
        int[] bucket = new int[n+1];
        for (int citation : citations) {
            if (citation >= n) {
                bucket[n]++;
            }
            else {
                bucket[citation]++;
            }
        }
        
        int h, cnt = 0;
        for (h = n; h >= 0; h--) {
            cnt += bucket[h];
            
            if (cnt >= h) {
                return h;
            }
        }
        
        return 0;
    }
}