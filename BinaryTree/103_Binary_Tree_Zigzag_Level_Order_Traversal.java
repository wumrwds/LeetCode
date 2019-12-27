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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        
        if (root == null) {
            return result;
        }
        
        boolean leftFirst = true;
        LinkedList<TreeNode> bfsQueue = new LinkedList<>();
        bfsQueue.offer(root);
        
        while (!bfsQueue.isEmpty()) {
            int levelSize = bfsQueue.size();
            List<Integer> levelResult = new LinkedList<>();
            LinkedList<TreeNode> tmp = new LinkedList<>();
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode head = bfsQueue.pollLast();
                levelResult.add(head.val);
                
                if (leftFirst) {
                    if (head.left != null) {
                        tmp.add(head.left);
                    }
                    if (head.right != null) {
                        tmp.add(head.right);
                    }
                }
                else {
                    if (head.right != null) {
                        tmp.add(head.right);
                    }
                    if (head.left != null) {
                        tmp.add(head.left);
                    }
                }
            }
            
            bfsQueue = tmp;
            result.add(levelResult);
            leftFirst = !leftFirst;
        }
        
        return result;
    }
}