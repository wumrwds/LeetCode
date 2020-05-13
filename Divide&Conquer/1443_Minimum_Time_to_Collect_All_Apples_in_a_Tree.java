class Solution {
    
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        // construct tree
        List<Set<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
        }
        
        return helpCollect(0, tree, hasApple);
    }
    
    private int helpCollect(int cur, List<Set<Integer>> tree, List<Boolean> hasApple) {
        int distCnt = 0;
        for (Integer child : tree.get(cur)) {
            int subDist = helpCollect(child, tree, hasApple);
            
            if (hasApple.get(child)) {
                distCnt += 2;
                
                if (subDist > 0) {
                    distCnt += subDist;
                }
            }
            else if (subDist > 0) {
                distCnt += (subDist + 2);
            }
        }
        
        return distCnt;
    }
}