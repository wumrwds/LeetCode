class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int stick : sticks) {
            minHeap.offer(stick);
        }
        
        int cost = 0;
        while (minHeap.size() > 1) {
            int min1 = minHeap.poll();
            int min2 = minHeap.poll();
            
            int merged = min1 + min2;
            minHeap.offer(merged);
            cost += merged;
        }
        
        return cost;
    }
}