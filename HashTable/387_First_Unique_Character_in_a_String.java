class Solution {
    public int firstUniqChar(String s) {
        Set<Character> hashSet = new HashSet<>();
        Map<Character, Integer> linkedHashMap = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            
            if (!hashSet.contains(ch)) {
                hashSet.add(ch);
                linkedHashMap.put(ch, i);
            }
            else {
                if (linkedHashMap.containsKey(ch)) {
                    linkedHashMap.remove(ch);
                } 
            }
        }
        
        Iterator<Integer> iterator = linkedHashMap.values().iterator();
        
        if (iterator.hasNext()) {
            return iterator.next();
        }
        
        return -1;
    }
}