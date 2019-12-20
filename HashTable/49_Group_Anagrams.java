class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hashMap = new HashMap<>();
        for (String str : strs) {
            String key = countChar(str);
            List<String> group = hashMap.getOrDefault(key, new LinkedList<>());
            group.add(str);
            hashMap.put(key, group);
        }
        
        List<List<String>> ans = new LinkedList<>();
        for (List<String> value : hashMap.values()) {
            ans.add(value);
        }
        
        return ans;
    }
    
    private String countChar(String s) {
        int[] cnt = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (cnt[i] != 0) {
                sb.append(String.format("%s:%d", 'a' + i, cnt[i]));
            }
        }
        
        return sb.toString();
    }
}