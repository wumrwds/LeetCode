class Solution {
    /*
    
    1. sort
    2. DFS
    3. skip duplicates of each iteration
    4. permutation
    
    */
    private int cnt;
    
    public int numTilePossibilities(String tiles) {
        int[] cntMap = new int[26];
        for (char ch : tiles.toCharArray()) {
            cntMap[ch - 'A']++;
        }
        
        cnt = 0;
        
        dfs(cntMap);
        
        return cnt;
    }
    
    private void dfs(int[] cntMap) {
        for (int i = 0; i < 26; i++) {
            if (cntMap[i] == 0) {
                continue;
            }
            
            cnt++;
            
            cntMap[i]--;
            dfs(cntMap);
            cntMap[i]++;
        }
    }
}