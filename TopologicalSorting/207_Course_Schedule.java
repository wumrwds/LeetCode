class Solution {
    /**
     * Checks whether it is possible to finish all courses.
     * 
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // build gragh
        List<List<Integer>> adjacencyList = buildGragh(numCourses, prerequisites);
        
        // topological sorting
        // calculate indegrees of every nodes in the gragh
        int[] indegrees = calculateIndegrees(adjacencyList);
        
        // find nodes with 0 indegree
        Queue<Integer> tsQueue = new LinkedList<>();
        boolean[] isRemoved = new boolean[numCourses];
        for(int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                tsQueue.offer(i);
            }
        }

        // no enterance node
        if (tsQueue.size() == 0) {
            return false;
        }
        
        // bfs
        while (!tsQueue.isEmpty()) {
            Integer head = tsQueue.poll();
            List<Integer> neighbors = adjacencyList.get(head);
            isRemoved[head] = true;
            
            for (Integer neighbor : neighbors) {
                if (isRemoved[neighbor]) {
                    continue;
                }
                
                // the indegree of the node connected by head minus 1
                indegrees[neighbor]--;
                
                // check wheter it equals 0 after updating the indegree
                if (indegrees[neighbor] == 0) {
                    tsQueue.offer(neighbor);
                }
            }
        }
        
        // check whether there's any node not removed
        for (int i = 0; i < numCourses; i++) {
            if (!isRemoved[i]) {
                return false;
            }
        }
        
        return true;
    }
    
    private List<List<Integer>> buildGragh(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacencyList = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            adjacencyList.add(new LinkedList<>());
        }
        
        for (int[] prerequisite : prerequisites) {
            adjacencyList.get(prerequisite[0]).add(prerequisite[1]);
        }
        
        return adjacencyList;
    }
    
    private int[] calculateIndegrees(List<List<Integer>> adjacencyList) {
        int[] indegrees = new int[adjacencyList.size()];
        
        for (int i = 0; i < adjacencyList.size(); i++) {
            List<Integer> neighbors = adjacencyList.get(i);
            
            for (Integer neighbor : neighbors) {
                indegrees[neighbor]++;
            }
        }
        
        return indegrees;
    }
}