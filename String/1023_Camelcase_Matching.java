class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<>(queries.length);
        for (String query : queries) {
            ans.add(check(query, pattern));
        }
        
        return ans;
    }
    
    /*
    
    aFoB, aFaocBad, Fo
    
    FoB
    
    */
    private boolean check(String query, String pattern) {
        int m = query.length(), n = pattern.length();
            
        int p = 0, q = 0;
        char[] queryChar = query.toCharArray(), patternChar = pattern.toCharArray();
        while (p < m) {
            if (q < n && queryChar[p] == patternChar[q]) {
                q++;
            }
            else if ('A' <= queryChar[p] && queryChar[p] <= 'Z') {
                return false;
            }
            
            p++;
        }
        
        return q == n;
    }
}