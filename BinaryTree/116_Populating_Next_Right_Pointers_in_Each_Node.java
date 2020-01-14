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
        if (root == null) {
            return root;
        }
        
        root.next = null;
        
        Node levelHead = root;
        Node cur = null;
        
        while (levelHead.left != null) {
            cur = levelHead;
            
            cur.left.next = cur.right;
            
            while (cur.next != null) {
                cur.right.next = cur.next.left;
                cur = cur.next;
                cur.left.next = cur.right;
            }
            
            levelHead = levelHead.left;
        }
        
        return root;
    }
}