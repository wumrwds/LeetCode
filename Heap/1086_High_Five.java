class Solution {
    public int[][] highFive(int[][] items) {
        Map<Integer, PriorityQueue<Integer>> topFives = new HashMap<>();
        
        for (int[] item : items) {
            int id = item[0], score = item[1];
            
            PriorityQueue<Integer> topFive;
            if (!topFives.containsKey(id)) {
                topFive = new PriorityQueue<>();
                topFives.put(id, topFive);
            }
            else {
                topFive = topFives.get(id);
            }
            
            if (topFive.size() < 5) {
                topFive.offer(score);
            }
            else if (topFive.peek() < score) {
                topFive.poll();
                topFive.offer(score);
            }
        }
        
        int[][] ans = new int[topFives.size()][2];
        int i = 0;
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : topFives.entrySet()) {
            ans[i][0] = entry.getKey();
            PriorityQueue<Integer> topFive = entry.getValue();
            int sum = 0, size = topFive.size();
            while (!topFive.isEmpty()) {
                sum += topFive.poll();
            }
            
            ans[i][1] = sum / size;
            i++;
        }
        
        return ans;
    }
}