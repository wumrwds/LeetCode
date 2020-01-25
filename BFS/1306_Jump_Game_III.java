class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        
        Queue<Integer> bfsQueue = new LinkedList<>();
        boolean[] isVisited = new boolean[n];
        bfsQueue.offer(start);
        isVisited[start] = true;
        
        while (!bfsQueue.isEmpty()) {
            int head = bfsQueue.poll();
            if (arr[head] == 0) {
                return true;
            }
            
            for (int next : new int[]{head - arr[head], head + arr[head]}) {
                if (next >= 0 && next < n && !isVisited[next]) {
                    isVisited[next] = true;
                    bfsQueue.offer(next);
                }
            }
        }
        
        return false;
    }
}