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
    
    private class Pair {
        TreeNode node;
        int index;
        
        Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        
        Queue<Pair> bfsQueue = new LinkedList<>();
        bfsQueue.offer(new Pair(root, 0));
        
        Map<Integer, List<Integer>> resultMap = new TreeMap<>();
        while (!bfsQueue.isEmpty()) {
            int levelSize = bfsQueue.size();
            
            while (levelSize-- > 0) {
                Pair head = bfsQueue.poll();
                
                // get level list and insert
                List<Integer> levelList;
                if (!resultMap.containsKey(head.index)) {
                    levelList = new LinkedList<>();
                    resultMap.put(head.index, levelList);
                }
                else {
                    levelList = resultMap.get(head.index);
                }
                levelList.add(head.node.val);
                
                if (head.node.left != null) {
                    bfsQueue.offer(new Pair(head.node.left, head.index - 1));
                }
                
                if (head.node.right != null) {
                    bfsQueue.offer(new Pair(head.node.right, head.index + 1));
                }
            }
        }
        
        // tree map to list
        List<List<Integer>> result = new LinkedList<>();
        for (List<Integer> val : resultMap.values()) {
            result.add(val);
        }
        
        return result;
    }
}