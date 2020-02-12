class Solution {
    /*
    Sliding window:
     - Use a int array to record the occurence for every letter
     - extend the window until the sum of all non-maximum cnt is greater than k, record the window length
     - shrink the window until it is valid again
    */
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int start = 0, end = 0;
        int[] cnt = new int[26];
        char[] chars = s.toCharArray();
        
        int maxLen = 0;
        while (end < n) {
            cnt[chars[end] - 'A']++;
            end++;
            
            while (start < end && !isValid(cnt, k)) {
                // shrink the window
                cnt[chars[start] - 'A']--;
                start++;
            }
            
            maxLen = Math.max(maxLen, end - start);
        }
        
        return maxLen;
    }
    
    private boolean isValid(int[] cnt, int k) {
        int totalCnt = 0, maxCnt = 0;
        for (int c : cnt) {
            totalCnt += c;
            maxCnt = Math.max(maxCnt, c);
        }
        
        return (totalCnt - maxCnt) <= k;
    }








    public int characterReplacement1(String s, int k) {
        int len = s.length();
        int[] count = new int[26];
        int start = 0, maxCount = 0, maxLength = 0;
        for (int end = 0; end < len; end++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
            while (end - start + 1 - maxCount > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}