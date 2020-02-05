class Solution {
    
    private class TrieNode {
        private TrieNode[] links = new TrieNode[26];
        
        private boolean isWord;
        
        public boolean contains(char ch) {
            return links[ch - 'a'] != null;
        }
    }
    
    public String replaceWords(List<String> dict, String sentence) {
        // construct Trie
        TrieNode root = new TrieNode(), cur;
        for (String word : dict) {
            cur = root;
            
            for (char ch : word.toCharArray()) {
                if (!cur.contains(ch)) {
                    cur.links[ch - 'a'] = new TrieNode();
                }
                
                cur = cur.links[ch - 'a'];
            }
            
            cur.isWord = true;
        }
        
        // split sentence
        String[] words = sentence.split(" ");
        
        // reconstruct sentence
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(search(root, word) + " ");
        }
        
        return sb.substring(0, sb.length() - 1);
    }

    /*
    cat
    
    cattle, cat, the, cap
    
    */
    private String search(TrieNode root, String word) {
        TrieNode cur = root;
        StringBuilder res = new StringBuilder();
        for (char ch : word.toCharArray()) {
            if (cur.contains(ch)) {
                cur = cur.links[ch - 'a'];
                res.append(ch);
                
                if (cur.isWord) {
                    return res.toString();
                }
            }
            else {
                return word;
            }
        }
        
        return res.toString();
    }
}