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
        
    private int cnt;
    
    public int pathSum(TreeNode root, int sum) {
        cnt = 0;
        
        Map<Integer, Integer> path = new HashMap<>();
        path.put(0, 1);
        
        dfs(root, path, 0, sum);
        
        return cnt;
    }
    
    private void dfs(TreeNode root, Map<Integer, Integer> path, int prefixSum, int target) {
        if (root == null) {
            return;
        }
        
        prefixSum += root.val;
        
        if (path.containsKey(prefixSum - target)) {
            cnt += path.get(prefixSum - target);
        }
        
        path.put(prefixSum, path.getOrDefault(prefixSum, 0) + 1);
        
        dfs(root.left, path, prefixSum, target);
        dfs(root.right, path, prefixSum, target);
        
        path.put(prefixSum, path.get(prefixSum) - 1);
    }
}