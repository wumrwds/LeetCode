class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || p == null || s.length() < p.length() || p.length() == 0) {
            return Collections.emptyList();
        }
        
        Map<Character, Integer> cntMap = new HashMap<>();
        for (char ch : p.toCharArray()) {
            cntMap.put(ch, cntMap.getOrDefault(ch, 0) + 1);
        }
        
        List<Integer> ans = new LinkedList<>();
        int start = 0, end = 0, incomplete = cntMap.size();
        char[] sArray = s.toCharArray();
        while (end < s.length()) {
            // expand end
            if (cntMap.containsKey(sArray[end])) {
                int updated = cntMap.get(sArray[end]) - 1;
                cntMap.put(sArray[end], updated);
                
                if (updated == 0) {
                    incomplete--;
                }
            }
            
            end++;
            
            // if window is valid, then shrink the window
            while (incomplete == 0) {
                if (cntMap.containsKey(sArray[start])) {
                    if (end - start == p.length()) {
                        ans.add(start);
                    }
                    
                    int updated = cntMap.get(sArray[start]) + 1;
                    cntMap.put(sArray[start], updated);
                    
                    if (updated > 0) {
                        incomplete++;
                    }
                }
                
                start++;
            }
        }
        
        return ans;
    }
}