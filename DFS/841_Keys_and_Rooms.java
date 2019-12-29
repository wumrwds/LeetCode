class Solution {
    private int cnt;
    
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // start from 0, check whether we can connect to all vertices using DFS
        int n = rooms.size();
        cnt = 0;
        boolean[] isVisited = new boolean[n];
        dfs(rooms, 0, isVisited);
        
        return cnt == n;
    }
    
    private void dfs(List<List<Integer>> graph, Integer vertex, boolean[] isVisited) {
        isVisited[vertex] = true;
        cnt++;
        
        List<Integer> neighbors = graph.get(vertex);
        for (Integer neighbor : neighbors) {
            if (!isVisited[neighbor]) {
                dfs(graph, neighbor, isVisited);
            }
        }
    }
}