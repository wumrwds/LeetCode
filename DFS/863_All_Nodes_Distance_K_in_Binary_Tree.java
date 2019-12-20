/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    private Map<TreeNode, Set<TreeNode>> graph;
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        graph = new HashMap<>();
        graph.put(root, new HashSet<>());
        
        dfs(root);
        
        // bfs
        Queue<TreeNode> bfsQueue = new LinkedList<>();
        Set<TreeNode> isVisited = new HashSet<>();
        bfsQueue.offer(target);
        
        List<Integer> ans = new LinkedList<>();
        while (!bfsQueue.isEmpty()) {
            int levelSize = bfsQueue.size();
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode head = bfsQueue.poll();
                isVisited.add(head);
                
                if (K == 0) {
                    ans.add(head.val);
                }
                
                Set<TreeNode> neighbors = graph.get(head);
                
                for (TreeNode neighbor : neighbors) {
                    if (!isVisited.contains(neighbor)) {
                        bfsQueue.offer(neighbor);
                    }
                }
            }
            
            if (--K < 0) {
                break;
            }
        }
        
        return ans;
    }
    
    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        
        Set<TreeNode> neighbors = graph.getOrDefault(root, new HashSet<>());
        
        if (root.left != null) {
            neighbors.add(root.left);
            
            Set<TreeNode> leftNeighbors = graph.getOrDefault(root.left, new HashSet<>());
            leftNeighbors.add(root);
            graph.put(root.left, leftNeighbors);
            
            dfs(root.left);
        }
        
        if (root.right != null) {
            neighbors.add(root.right);
            
            Set<TreeNode> rightNeighbors = graph.getOrDefault(root.right, new HashSet<>());
            rightNeighbors.add(root);
            graph.put(root.right, rightNeighbors);
            
            dfs(root.right);
        }
    }
    
}