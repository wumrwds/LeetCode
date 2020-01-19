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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return root;
        }
        
        TreeNode left = removeLeafNodes(root.left, target);
        TreeNode right = removeLeafNodes(root.right, target);
        
        if (left == null && right == null && target == root.val) {
            return null;
        }
        
        root.left = left;
        root.right = right;
        
        return root;
    }





    /*
    Bad implementation:
    */
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return root;
        }
        
        if (helper(root, target)) {
            root = null;
        }
        
        return root;
    }
    
    private boolean helper(TreeNode root, int target) {
        if (root.left == null && root.right == null) {
            if (target == root.val) {
                return true;
            }
        }
        else {
            if (root.left != null && helper(root.left, target)) {
                root.left = null;
            }
            if (root.right != null && helper(root.right, target)) {
                root.right = null;
            }
            
            if (root.left == null && root.right == null && target == root.val) {
                return true;
            }
        }
        
        return false;
    }
}