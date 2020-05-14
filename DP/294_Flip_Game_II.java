class Solution {
    private Map<String, Boolean> dp;
    
    public boolean canWin(String s) {
        dp = new HashMap<>();
        
        return helper(s);
    }
    
    private boolean helper(String pattern) {
        if (dp.containsKey(pattern)) {
            return dp.get(pattern);
        }
        
        List<String> candidates = possibleMoves(pattern);
        for (String c : candidates) {
            boolean canCandidateWin = helper(c);
            if (!canCandidateWin) {
                dp.put(pattern, true);
                return true;
            }
        }
        
        dp.put(pattern, false);
        return false;
    }
    
    private List<String> possibleMoves(String s) {
        List<String> candidates = new LinkedList<>();
        int n = s.length();
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i+1) == '+') {
                char[] chars = s.toCharArray();
                chars[i] = chars[i+1] = '-';
                candidates.add(new String(chars));
            }
        }
        
        return candidates;
    }
}