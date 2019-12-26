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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        
        if (root == null) {
            return result;
        }
        
        // corner case: [1] | if we don't have the following if clause, the result will be [1, 1] (duplicate)
        if (root.left != null || root.right != null) {
            result.add(root.val);
        }
        
        traverseLeft(root.left, result);
        traverseLeaves(root, result);
        traverseRight(root.right, result);
        
        return result;
    }
    
    private void traverseLeft(TreeNode root, List<Integer> result) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        
        result.add(root.val);
        
        if (root.left != null) {
            traverseLeft(root.left, result);
        }
        else {
            traverseLeft(root.right, result);
        }
    }
    
    private void traverseLeaves(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        
        if (root.left == null && root.right == null) {
            result.add(root.val);
        }
        
        traverseLeaves(root.left, result);
        traverseLeaves(root.right, result);
    }
    
    private void traverseRight(TreeNode root, List<Integer> result) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        
        if (root.right != null) {
            traverseRight(root.right, result);
        }
        else {
            traverseRight(root.left, result);
        }
        
        result.add(root.val);
    }
}