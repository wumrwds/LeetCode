class Solution {
    /*
    aab -> aba
    
    aaab -> abaa
    
    */
    public String reorganizeString(String S) {
        int[] cntMap = new int[26];
        for (int i = 0; i < S.length(); i++) {
            cntMap[S.charAt(i) - 'a']++;
        }
        
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < 26; i++) {
            if (cntMap[i] > 0) {
                maxHeap.offer(new int[]{i, cntMap[i]});
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            int[] top = maxHeap.poll();
            
            if (sb.length() == 0 || sb.charAt(sb.length() - 1) - 'a' != top[0]) {
                sb.append((char)('a' + top[0]));
                top[1]--;
            }
            else{ 
                if (!maxHeap.isEmpty()) {
                    int[] secondTop = maxHeap.poll();
                    sb.append((char)('a' + secondTop[0]));
                    if (--secondTop[1] > 0) {
                        maxHeap.offer(secondTop);
                    }
                }
                else {
                    return "";
                }
            }
            
            if (top[1] > 0) {
                maxHeap.offer(top);
            }
        }
        
        return sb.toString();
    }
}