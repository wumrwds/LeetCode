package top.wumrwds;


import top.wumrwds.entity.TreeNode;

import java.util.LinkedList;
import java.util.List;


/**
 * 257. Binary Tree Paths
 *
 * @author wumrwds
 */
public class Solution {

    /**
     * Returns all root-to-leaf paths.
     *
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new LinkedList<>();

        if (root == null) {
            return result;
        }

        List<String> left = binaryTreePaths(root.left);
        List<String> right = binaryTreePaths(root.right);

        // add root.value into each path of subtrees, then merge
        for (String path : left) {
            result.add(root.val + "->" + path);
        }

        for (String path : right) {
            result.add(root.val + "->" + path);
        }

        // for leaf nodes
        if (result.size() == 0) {
            result.add(String.valueOf(root.val));
        }

        return result;
    }
}