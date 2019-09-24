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
    private class ResultType {
        /** -1 -> non-complete, 0 -> complete, 1 - > full */
        private int state;
        private int depth;
        
        ResultType(int state, int depth) {
            this.state = state;
            this.depth = depth;
        }
    }
    
    /**
     * Divide & Conquer
     */
    public boolean isCompleteTree1(TreeNode root) {
        ResultType result = helper(root);
        
        return result.state >= 0 ? true : false;
    }
    
    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(1, 0);
        }

        ResultType leftResult = helper(root.left);
        ResultType rightResult = helper(root.right);

        if (leftResult.state != -1 && rightResult.state != -1) {
            if (leftResult.depth == rightResult.depth && leftResult.state == 1) {
                if (rightResult.state == 1) {
                    // full
                    return new ResultType(1, leftResult.depth + 1);
                }
                
                if (rightResult.state == 0) {
                    // complete
                    return new ResultType(0, leftResult.depth + 1);
                }
            }

            if (leftResult.depth == rightResult.depth + 1 && rightResult.state == 1) {
                if (leftResult.state >= 0 ) {
                    // left subtree is full or complete, return complete
                    return new ResultType(0, leftResult.depth + 1);
                }
            }
        }
        
        return new ResultType(-1, 0);
    }
    
    
    /**
     * BFS approach.
     * @param root
     * @return
     */
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        
        // bfs
        Queue<TreeNode> bfsQueue = new LinkedList<>();
        bfsQueue.offer(root);
        
        while (!bfsQueue.isEmpty()) {
            TreeNode head = bfsQueue.poll();
            
            if (head == null) {
                break;
            }
            
            bfsQueue.offer(head.left);
            bfsQueue.offer(head.right);
        }
        
        for (TreeNode remain : bfsQueue) {
            if (remain != null) {
                return false;
            }
        }
        
        return true;
    }
    
}