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
    private int max;
    
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        max = Integer.MIN_VALUE;
        helper(root);
        
        return max;
    }
    
    /**
     *
     * @return the maximum path from root
     */
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int leftRootMax = Math.max(0, helper(root.left));
        int rightRootMax = Math.max(0, helper(root.right));
        
        int curMax = leftRootMax + rightRootMax + root.val;
        
        if (curMax > max) {
            max = curMax;
        }
        
        return Math.max(leftRootMax, rightRootMax) + root.val;
    }
}