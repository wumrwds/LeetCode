package top.wumrwds;


import org.junit.Assert;
import top.wumrwds.entity.TreeNode;
import top.wumrwds.util.TreeUtils;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * 236. Lowest Common Ancestor of a Binary Tree
 *
 * @author wumrwds
 */
public class Solution {
    /**
     * Finds the lowest common ancestor (LCA) of two given nodes in the tree.
     * 
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        // preorder traversal
        //  p        q        p   1
        // / \  or  / \  or  / \ / \
        // q 1      1 p      8 4 5 q
        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // one side each, select root as LCA
        if (left != null && right != null) {
            return root;
        }

        // if LCA doesn't occur in the left
        if (left == null) {
            return right;
        }

        // if LCA doesn't occur in the right
        if (right == null) {
            return left;
        }

        // both subtrees don't have p or q
        return null;
    }
}