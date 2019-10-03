class AutocompleteSystem {
    private class TrieNode {
        private Map<Character, TrieNode> links;
        private boolean isEnd;
        private Map<String, Integer> cnt;
        
        TrieNode() {
            links = new HashMap<>();
            cnt = new HashMap<>();
        }
        
        private boolean contains(char ch) {
            return links.containsKey(ch);
        }
        
        private TrieNode createNode(char ch) {
            TrieNode newNode = new TrieNode();
            links.put(ch, newNode);
            return newNode;
        }
        
        private TrieNode get(char ch) {
            return links.get(ch);
        }
        
        private void updateCnt(String sentence, int count) {
            cnt.put(sentence, cnt.getOrDefault(sentence, 0) + count);
        }
        
        private Set<Map.Entry<String, Integer>> entrySet() {
            return cnt.entrySet();
        }
        
        private void setEnd() {
            isEnd = true;
        }
        
        private boolean isEnd() {
            return isEnd;
        }
    }
    
    private TrieNode root;
    private String prefix;
    private TrieNode curNode;
    private boolean notFound;
    
    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        prefix = "";
        curNode = root;
        notFound = false;
        
        for (int i = 0; i < sentences.length; i++) {
            insert(sentences[i], times[i]);
        }
    }
    
    public List<String> input(char c) {
        if (c == '#') {
            insert(prefix, 1);
            curNode = root;
            prefix = "";
            notFound = false;
            return Collections.emptyList();
        }
        
        // append the current character
        prefix += c;
        
        if (!curNode.contains(c) || notFound) {
            notFound = true;
            return Collections.emptyList();
        }
        
        // move to current node
        curNode = curNode.get(c);
        
        Set<Map.Entry<String, Integer>> entrySet = curNode.entrySet();
        PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>((e1, e2) -> {
            int diff = e2.getValue() - e1.getValue();
            if (diff == 0) {
                return e1.getKey().compareTo(e2.getKey());
            }
            return diff;
        });
        for (Map.Entry<String, Integer> entry : entrySet) {
            maxHeap.offer(entry);
        }
        
        List<String> result = new ArrayList<>(3);
        for (int i = 0; i < 3; i++) {
            if (!maxHeap.isEmpty()) {
                result.add(maxHeap.poll().getKey());
            }
        }
        
        return result;
    }
    
    private void insert(String sentence, int count) {
        TrieNode cur = root;
        for (char ch : sentence.toCharArray()) {
            if (!cur.contains(ch)) {
                cur = cur.createNode(ch);
            }
            else {
                cur = cur.get(ch);
            }
            
            // update count map
            cur.updateCnt(sentence, count);
        }
        // set the node as an end
        cur.setEnd();
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */