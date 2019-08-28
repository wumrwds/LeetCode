package top.wumrwds;


import org.junit.Assert;
import top.wumrwds.entity.TreeNode;
import top.wumrwds.util.TreeUtils;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * 104. Maximum Depth of Binary Tree
 *
 * @author wumrwds
 */
public class Solution {

    /**
     * Finds the maximum depth of a binary tree.
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // divide & conquer
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return left > right ? left + 1 : right + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root1 = TreeUtils.constructBinaryTree(new ArrayList<>(Arrays.asList(3,9,20,null,null,15,7)));
        Assert.assertEquals(3, solution.maxDepth(root1));

        TreeNode root2 = TreeUtils.constructBinaryTree(new ArrayList<>(Arrays.asList(3,9,null,10,null,11,null, 12)));
        Assert.assertEquals(5, solution.maxDepth(root2));

        TreeNode root3 = TreeUtils.constructBinaryTree(new ArrayList<>(Arrays.asList(3,9,null,10,12,11,43, 12)));
        Assert.assertEquals(4, solution.maxDepth(root3));

        Assert.assertEquals(0, solution.maxDepth(null));

        TreeNode root4 = TreeUtils.constructBinaryTree(new ArrayList<>(Arrays.asList(1)));
        Assert.assertEquals(1, solution.maxDepth(root4));

        System.out.println("All test cases pass.");
    }
}