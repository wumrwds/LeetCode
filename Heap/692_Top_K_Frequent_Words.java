class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> cntMap = new HashMap<>();
        for (String word : words) {
            cntMap.put(word, cntMap.getOrDefault(word, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k, (a, b) -> {
            int diff = a.getValue() - b.getValue();
            if (diff == 0) {
                // Note that here's reversed
                return b.getKey().compareTo(a.getKey());
            }
            return diff;
        });
        for (Map.Entry<String, Integer> entry : cntMap.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(entry);
            }
            else if (minHeap.peek().getValue() < entry.getValue() || (minHeap.peek().getValue() == entry.getValue() 
                        && minHeap.peek().getKey().compareTo(entry.getKey()) > 0)) {
                minHeap.poll();
                minHeap.offer(entry);
            }
        }
        
        String[] ans = new String[k];
        for (int i = k - 1; i >= 0; i--) {
            // System.out.println(minHeap.peek().getKey() + ", " + minHeap.peek().getKey());
            ans[i] = minHeap.poll().getKey();
        }
        
        return Arrays.asList(ans);
    }
}