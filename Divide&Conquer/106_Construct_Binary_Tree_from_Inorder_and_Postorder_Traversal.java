package top.wumrwds;


import top.wumrwds.entity.TreeNode;
import top.wumrwds.util.TreeUtils;

/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 *
 * @author wumrwds
 */
public class Solution {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 || inorder.length != postorder.length) {
            return null;
        }

        return helper(inorder, 0, postorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode helper(int[] inorder, int inorderStart, int inorderEnd, int[] postorder, int postorderStart, int postorderEnd) {
        if (inorderStart > inorderEnd || postorderStart > postorderEnd) {
            return null;
        }

        if (postorderStart == postorderEnd) {
            return new TreeNode(postorder[postorderStart]);
        }

        int rootVal = postorder[postorderEnd];
        TreeNode root = new TreeNode(rootVal);

        int rootInorderIdx = findFirstIdx(inorder, inorderStart, inorderEnd, rootVal);

        root.left = helper(inorder, inorderStart, rootInorderIdx - 1, postorder, postorderStart, postorderStart + (rootInorderIdx - 1 - inorderStart));
        root.right = helper(inorder, rootInorderIdx + 1, inorderEnd, postorder, postorderStart + (rootInorderIdx - inorderStart), postorderEnd - 1);

        return root;
    }

    private int findFirstIdx(int[] nums, int start, int end, int target) {
        for (int i = start; i <= end; i++) {
            if (nums[i] == target) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] inorder = new int[]{9,3,15,20,7};
        int[] postorder = new int[]{9,15,7,20,3};

        TreeUtils.printBinaryTree(solution.buildTree(inorder, postorder));

        int[] inorder2 = new int[]{6,9,8,1,15,20,7};
        int[] postorder2 = new int[]{6,8,9,15,7,20,1};

        TreeUtils.printBinaryTree(solution.buildTree(inorder2, postorder2));

        int[] inorder3 = new int[]{6,9,8,1,15};
        int[] postorder3 = new int[]{6,8,9,15,1};

        TreeUtils.printBinaryTree(solution.buildTree(inorder3, postorder3));

        int[] inorder4 = new int[]{6, 9};
        int[] postorder4 = new int[]{6, 9};

        TreeUtils.printBinaryTree(solution.buildTree(inorder4, postorder4));
    }
}