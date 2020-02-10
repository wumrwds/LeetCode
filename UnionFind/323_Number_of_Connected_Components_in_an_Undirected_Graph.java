class Solution {
    public int countComponents(int n, int[][] edges) {
        // build map
        Map<Integer, Set<Integer>> adjacencyList = buildGraph(n, edges);
        
        // bfs
        int cnt = 0;
        Queue<Integer> bfsQueue = new LinkedList<>();
        boolean[] isVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (isVisited[i]) {
                continue;
            }
            
            bfsQueue.offer(i);
            isVisited[i] = true;
            while (!bfsQueue.isEmpty()) {
                Integer head = bfsQueue.poll();
                Set<Integer> neighbors = adjacencyList.get(head);
                
                for (Integer neighbor : neighbors) {
                    if (!isVisited[neighbor]) {
                        bfsQueue.offer(neighbor);
                        isVisited[neighbor] = true;
                    }
                }
            }
            
            cnt++;
        }
        
        return cnt;
    }
    
    private Map<Integer, Set<Integer>> buildGraph(int n, int[][] edges) {
        Map<Integer, Set<Integer>> adjacencyList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.put(i, new HashSet<>());
        }
        
        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }
        
        return adjacencyList;
    } 
}