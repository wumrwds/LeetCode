/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        
        Queue<TreeNode> bfsQueue = new LinkedList<>();
        bfsQueue.offer(root);
        
        List<List<Integer>> res = new LinkedList<>();
        while (!bfsQueue.isEmpty()) {
            int levelSize = bfsQueue.size();
            List<Integer> elements = new LinkedList<>();
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode head = bfsQueue.poll();
                elements.add(head.val);
                if (head.left != null) {
                    bfsQueue.offer(head.left);
                }
                if (head.right != null) {
                    bfsQueue.offer(head.right);
                }
            }
            
            res.add(elements);
        }
        
        return res;
    }
}