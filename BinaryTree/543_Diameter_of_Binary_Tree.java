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
    
    /**
     * Returns the diameter of a binary tree.
     * 
     * Two cases: 
     *      1⃣️ max diameter occurs in substree 
     *      2⃣️ max diameter occurs in crossing root node
     * 
     * @param
     * @return 
     */
    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        
        helper(root);
        
        return max;
    }
    
    /**
     * Returns the depth of binary tree. Updates max diameter in the process.
     */
    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = helper(root.left);
        int right = helper(root.right);
        
        max = Math.max(max, left + right);
        
        return Math.max(left, right) + 1;
    }
}