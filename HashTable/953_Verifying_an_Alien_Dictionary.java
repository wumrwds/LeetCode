class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        // we can use int[] orderMap to replace hashmap here
        Map<Character, Integer> orderMap = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }
        
        for (int i = 0; i < words.length - 1; i++) {
            if (!isOrdered(orderMap, words[i], words[i+1])) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean isOrdered(Map<Character, Integer> orderMap, String word1, String word2) {
        int minLen = Math.min(word1.length(), word2.length());

        for (int j = 0; j < minLen; j++) {
            char ch1 = word1.charAt(j);
            char ch2 = word2.charAt(j);

            if (ch1 != ch2) {
                int idx1 = orderMap.get(ch1);
                int idx2 = orderMap.get(ch2);
                if (idx1 < idx2) {
                    return true;
                }
                else {
                    return false;
                }
            }
        }
        
        // case: ["apple","app"]
        if (word1.length() > word2.length()) {
            return false;
        }
        
        return true;
    }
}