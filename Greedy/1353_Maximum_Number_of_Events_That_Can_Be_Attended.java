class Solution {
    public int maxEvents(int[][] events) {
        // sort by start date
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        
        for (int[] event : events) {
            System.out.println(Arrays.toString(event));
        }
        
        // use a priority queue to get the first due event
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int n = events.length, day = 1, i = 0, cnt = 0;
        while (i < n || !pq.isEmpty()) {
            while (i < n && events[i][0] <= day) {
                pq.offer(events[i++]);
            }
            
            if (!pq.isEmpty()) {
                pq.poll();
                cnt++;
            }
            
            while (!pq.isEmpty() && pq.peek()[1] <= day) {
                pq.poll();
            }
            
            day++;
        }
        
        return cnt;
    }
}