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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        
        if (root == null) {
            return ans;
        }
        
        Queue<TreeNode> bfsQueue = new LinkedList<>();
        bfsQueue.offer(root);
        while (!bfsQueue.isEmpty()) {
            int levelSize = bfsQueue.size();
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode head = bfsQueue.poll();
                if (i == 0) {
                    ans.add(head.val);
                }
                
                if (head.right != null) {
                    bfsQueue.offer(head.right);
                }
                
                if (head.left != null) {
                    bfsQueue.offer(head.left);
                }
            }
        }
        
        return ans;
    }
}