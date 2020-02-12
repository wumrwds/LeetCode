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
    private int res;
    
    public int distributeCoins(TreeNode root) {
        res = 0;
        
        helper(root);
        
        return res;
    }
    
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = helper(root.left);
        int right = helper(root.right);
        
        res += (Math.abs(left) + Math.abs(right));
        
        return root.val + left + right - 1;
    }
}