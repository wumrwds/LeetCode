class Solution {
    private class TrieNode {
        private Map<Character, TrieNode> links = new HashMap<>();
        
        private boolean isWord;
        
        public boolean contains(char ch) {
            return links.containsKey(ch);
        }
    }
    
    public String longestWord(String[] words) {
        TrieNode root = constructTrie(words);
        
        String[] res = new String[] {""};
        dfs(root, "", res);
        
        return res[0];
    }
    
    private TrieNode constructTrie(String[] words) {
        TrieNode trie = new TrieNode(), cur;
        for (String word : words) {
            cur = trie;
            for (char ch : word.toCharArray()) {
                if (!cur.contains(ch)) {
                    // insert new node
                    cur.links.put(ch, new TrieNode());
                }
                cur = cur.links.get(ch);
            }
            
            cur.isWord = true;
        }
        
        return trie;
    }
    
    private void dfs(TrieNode root, String cur, String[] result) {
        if (root.links.size() == 0 && cur.length() > result[0].length() 
                     || (cur.length() == result[0].length() && cur.compareTo(result[0]) < 0)) {
            result[0] = cur;
        }
        
        for (Map.Entry<Character, TrieNode> entry : root.links.entrySet()) {
            Character ch = entry.getKey();
            TrieNode next = entry.getValue();
            if (next.isWord) {
                dfs(next, cur + ch, result);
            }
            else if (cur.length() > result[0].length() 
                     || (cur.length() == result[0].length() && cur.compareTo(result[0]) < 0)) {
                
                result[0] = cur;
            }
        }
    }
}