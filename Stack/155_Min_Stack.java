class MinStack {
    
    private Node stack;
    
    private class Node {
        int val;
        int min;
        Node next;
        
        Node(int val, int min) {
            this.val = val;
            this.min = min;
        }
        
        Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
    
    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        if (stack == null) {
            stack = new Node(x, x);
            return;
        }
        stack = new Node(x, Math.min(x, stack.min), stack);
    }
    
    public void pop() {
        if (stack != null) {
            stack = stack.next;
        }
    }
    
    public int top() {
        return stack.val;
    }
    
    public int getMin() {
        return stack.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */