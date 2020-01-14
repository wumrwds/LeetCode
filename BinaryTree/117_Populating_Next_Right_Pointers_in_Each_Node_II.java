/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        Node levelHead = root, cur = root, lead = null;
        
        while (cur != null) {
            levelHead = lead = null;
            
            boolean isLeft = true;
            while (cur != null) {
                Node checked;
                if (isLeft) {
                    checked = cur.left;
                }
                else {
                    checked = cur.right;
                }
                isLeft = !isLeft;

                if (checked != null) {
                    if (levelHead == null) {
                        levelHead = checked;
                    } 
                    if (lead != null) {
                        lead.next = checked;
                    }
                    lead = checked;
                }
                
                if (isLeft) {
                    cur = cur.next;
                }
            }
            
            cur = levelHead;
        }
        
        return root;
    }
}