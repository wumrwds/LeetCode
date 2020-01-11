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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode helper(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
        if (pe - ps < 0 || ie - is < 0) {
            return null;
        } 
        
        int rootVal = preorder[ps];
        TreeNode root = new TreeNode(rootVal);
        
        int llen = 0;
        while (inorder[is + llen] != rootVal) {
            llen++;
        }

        TreeNode left = helper(preorder, ps+1, ps+llen, inorder, is, is + llen - 1);
        TreeNode right = helper(preorder, ps+llen+1, pe, inorder, is + llen + 1, ie);
        
        root.left = left;
        root.right = right;
        
        return root;
    }
}