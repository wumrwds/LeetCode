package top.wumrwds;


import org.junit.Assert;
import top.wumrwds.entity.TreeNode;
import top.wumrwds.util.TreeUtils;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * 110. Balanced Binary Tree
 *
 * @author wumrwds
 */
public class Solution {

    private class ResultType {
        private boolean isBalanced;
        private int maxDepth;

        private ResultType(boolean isBalanced, int maxDepth) {
            this.isBalanced = isBalanced;
            this.maxDepth = maxDepth;
        }
    }

    /**
     * Determines whether a binary tree is height-balanced.
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        return helper(root).isBalanced;
    }

    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(true, 0);
        }

        ResultType left = helper(root.left);
        ResultType right = helper(root.right);

        if (!left.isBalanced || !right.isBalanced) {
            // if subtree is unbalanced
            return new ResultType(false, -1);
        }

        if (Math.abs(left.maxDepth - right.maxDepth) > 1) {
            // if not balanced in this node
            return new ResultType(false, -1);
        }

        return new ResultType(true, Math.max(left.maxDepth, right.maxDepth) + 1);
    }
}