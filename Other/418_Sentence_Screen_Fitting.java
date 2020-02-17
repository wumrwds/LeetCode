class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int n = sentence.length;
        
        // precomputing that if a line started from sentence[i] in the begining of the line
        // how many times the sentence can be filled in; which word will be the beginning
        // word for the next line.
        int[] next = new int[n], times = new int[n];
        for (int i = 0; i < n; i++) {
            int cur = i, cnt = 0, j = 0;
            
            while (j < cols && j + sentence[cur].length() <= cols) {
                j += sentence[cur].length() + 1;
                cur = (cur + 1) % n;
                if (cur == 0) {
                    cnt++;
                }
            }
            
            times[i] = cnt;
            next[i] = cur;
        }
        
        int ans = 0;
        for (int i = 0, cur = 0; i < rows; i++) {
            ans += times[cur];
            cur = next[cur];
        }
        return ans;
    }
}