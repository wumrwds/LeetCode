class Solution {
    /*
    it's a question of bag intersection. But we don't need to sort
    
    abell
    111 2
    
    abell
    111 2
    
    elor
    1212
    
    keeps the min(cnt[0...n-1]) for every letter.
    */
    public List<String> commonChars(String[] A) {
        if (A == null || A.length == 0) {
            return Collections.emptyList();
        }
        
        int n = A.length;
        
        int[] cnt = new int[26];
        Arrays.fill(cnt, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            int[] curCnt = new int[26];
            for (char ch : A[i].toCharArray()) {
                curCnt[ch - 'a']++;
            }
            
            for (int j = 0; j < 26; j++) {
                cnt[j] = Math.min(cnt[j], curCnt[j]);
            }
        }
        
        List<String> res = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            for (int k = 0; k < cnt[i]; k++) {
                res.add("" + (char) ('a' + i));
            }
        }
        
        return res;
    }
}