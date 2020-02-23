class Solution {
    private boolean isFound;
    private List<Integer> ans;
    
    public List<Integer> splitIntoFibonacci(String S) {
        isFound = false;
        
        dfs(S, 0, -1, -1, new ArrayList<>());
        
        return ans == null ? Collections.emptyList() : ans;
    }
    
    private void dfs(String S, int idx, int prev1, int prev2, List<Integer> res) {
        if (isFound) {
            return;
        }
        
        if (idx >= S.length()) {
            if (res.size() > 2) {
                ans = new LinkedList<>(res);
                isFound = true;
            }
            return;
        }
        
        if (S.charAt(idx) == '0') {
            if (prev1 < 0 || prev2 < 0 || (prev1 >= 0 && prev2 >= 0 && 0 == prev1 + prev2)) {
                res.add(0);
                dfs(S, idx + 1, prev2, 0, res);
                res.remove(res.size() - 1);
            }
            return;
        }
        
        for (int i = 1; i <= 10; i++) {
            if (idx + i > S.length()) {
                break;
            }

            String curStr = S.substring(idx, idx + i);
            
            if (curStr.length() == 10 && curStr.compareTo("" + Integer.MAX_VALUE) > 0) {
                break;
            }
            
            int cur = Integer.parseInt(curStr);
            
            if (prev1 < 0 || prev2 < 0 || (prev1 >= 0 && prev2 >= 0 && cur == prev1 + prev2)) {
                res.add(cur);
                dfs(S, idx + i, prev2, cur, res);
                res.remove(res.size() - 1);
            }
        }
    }
}