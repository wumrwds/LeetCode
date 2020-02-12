class Solution {
    /*
    Only when we meet a ')', we need to calculate the score of this pair of parenthese.
    And if the current inner score is 0, that means there's no inner parentheses inside, we just increase
    by 1; if the current inner score is larger than 0, we know there're some terms inside, we need to
    double the score.
    
    (()(()))(()())
    
    0           ""                  we need push a zero initially, it represents the current score (lowest level)
    0 0 0       ((
    0 1 0 0     (()((
    0 1 1       (()(()     
    0 3         (()(())
    6           (()(()))
    6 0 0       (()(()))((
    6 1         (()(()))(()
    6 1 0       (()(()))(()(
    6 2         (()(()))(()()
    10          (()(()))(()())
    */
    public int scoreOfParentheses(String S) {
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(0);
        for (char ch : S.toCharArray()) {
            if (ch == '(') {
                stack.push(0);
            }
            else {
                int cur = stack.pop();
                
                if (cur > 0) {
                    stack.push(stack.pop() + 2 * cur);
                }
                else {
                    stack.push(stack.pop() + 1);
                }
            }
        }
        
        return stack.peek();
    }
}