class Solution {
    
    private class Trie {
        private Trie[] links = new Trie[26];
        List<String> suggestion = new ArrayList<>();
    }
    
    private Trie root;
    
    private void insert(String product) {
        Trie cur = root;
        for (int i = 0; i < product.length(); i++) {
            char ch = product.charAt(i);
            if (cur.links[ch - 'a'] == null) {
                cur.links[ch - 'a'] = new Trie();
            }
            cur = cur.links[ch - 'a'];
            cur.suggestion.add(product);
        }
    }
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        root = new Trie();
        
        // insert
        Arrays.sort(products);
        for (String product : products) {
            insert(product);
        }
        
        Trie cur = root;
        List<List<String>> ans = new LinkedList<>();
        for (int i = 0; i < searchWord.length(); i++) {
            char ch = searchWord.charAt(i);
            List<String> tmp = new LinkedList<>();
            
            if (cur == null || cur.links[ch - 'a'] == null) {
                cur = null;
            }
            else {
                // tmp.addAll(cur.links[ch - 'a'].suggestion);
                int k = Math.min(3, cur.links[ch - 'a'].suggestion.size());
                for (int j = 0; j < k; j++) {
                    tmp.add(cur.links[ch - 'a'].suggestion.get(j));
                }
                cur = cur.links[ch - 'a'];
            }
            
            ans.add(tmp);
        }
        
        return ans;
    }
}