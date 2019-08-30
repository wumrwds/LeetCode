package top.wumrwds;


import top.wumrwds.entity.TreeNode;
import top.wumrwds.util.TreeUtils;

import java.util.*;


/**
 * 297. Serialize and Deserialize Binary Tree
 *
 * @author wumrwds
 */
public class Solution {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }

        List<Integer> elements = new LinkedList<>();

        Queue<TreeNode> bfsQueue = new LinkedList<>();
        bfsQueue.offer(root);

        while (!bfsQueue.isEmpty()) {
            for (int i = 0; i < bfsQueue.size(); i++) {
                TreeNode head = bfsQueue.poll();

                if (head != null) {
                    elements.add(head.val);
                    bfsQueue.add(head.left);
                    bfsQueue.add(head.right);
                }
                else {
                    elements.add(null);
                }
            }
        }

        return prettyPrint(elements);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || "[]".equals(data)) {
            return null;
        }

        List<String> elements = Arrays.asList(data.substring(1, data.length() - 1).split(","));

        boolean isLeft = true;
        TreeNode root = new TreeNode(Integer.valueOf(elements.get(0))), current = null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        for (int i = 1; i < elements.size(); i++) {
            String element = elements.get(i);

            // turn to next node to be added
            if (isLeft) {
                current = queue.poll();
            }

            if (!"null".equals(element)) {
                TreeNode newNode = new TreeNode(Integer.valueOf(element));

                if (isLeft) {
                    current.left = newNode;
                }
                else {
                    current.right = newNode;
                }

                // put the node into queue (it may not pop all nodes up in the end)
                queue.add(newNode);
            }

            // switch flag
            isLeft = isLeft ? false : true;
        }

        return root;
    }


    private String prettyPrint(List<Integer> elements) {
        int lastNonNullIdx = -1;

        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i) != null) {
                lastNonNullIdx = i;
            }
        }

        if (lastNonNullIdx == -1) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i <= lastNonNullIdx; i++) {
            sb.append(elements.get(i) + ",");
        }

        // trim end comma and append bracket
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");

        return sb.toString();
    }
}