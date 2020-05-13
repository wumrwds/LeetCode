/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        
        Node dummy = new Node();
        dummy.next = head;
        
        helper(dummy, head);
        
        head.prev = null;
        return head;
    }
    
    private Node helper(Node p, Node q) {
        if (q == null) {
            return p;
        }
        
        p.next = q;
        q.prev = p;
        
        Node r = q.next;
        Node tail = helper(q, q.child);
        q.child = null;
        
        return helper(tail, r);
    }
}