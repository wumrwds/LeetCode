package top.wumrwds;


import top.wumrwds.entity.Node;

import java.util.*;


/**
 * 297. Serialize and Deserialize Binary Tree
 *
 * @author wumrwds
 */
public class Solution {
    /**
     * Deep copies a gragh.
     *
     * @param node
     * @return
     */
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        // get all nodes
        List<Node> nodes = getGraghNodes(node);

        // create new nodes
        Map<Node, Node> newNodes = createNewNodes(nodes);

        // copy edges
        for(Node n : nodes) {
            List<Node> newNeighbors = new LinkedList();
            for (Node neighbor : n.neighbors) {
                newNeighbors.add(newNodes.get(neighbor));
            }

            newNodes.get(n).neighbors = newNeighbors;
        }

        return newNodes.get(node);
    }

    private List<Node> getGraghNodes(Node node) {
        List<Node> nodes = new LinkedList<>();

        Queue<Node> bfsQueue = new LinkedList<>();
        Set<Node> bfsSet = new HashSet<>();
        bfsQueue.offer(node);
        bfsSet.add(node);

        while(!bfsQueue.isEmpty()) {
            Node head = bfsQueue.poll();

            nodes.add(head);

            for (Node neighbor : head.neighbors) {
                if (!bfsSet.contains(neighbor)) {
                    bfsQueue.offer(neighbor);
                    bfsSet.add(neighbor);
                }
            }
        }

        return nodes;
    }

    private Map<Node, Node> createNewNodes(List<Node> nodes) {
        Map<Node, Node> newNodes = new HashMap();

        for (Node node : nodes) {
            newNodes.put(node, new Node(node.val, null));
        }

        return newNodes;
    }
}