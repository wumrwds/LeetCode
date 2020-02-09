class Solution {
    /*
    Iterate the expression from tail, whenever encounter a character before '?', 
    calculate the right value and push back to stack.
    */
    public String parseTernaryStack(String expression) {
        LinkedList<Character> valStack = new LinkedList<>();
        
        char[] charArray = expression.toCharArray();
        int n = expression.length();
        for (int i = n - 1; i >= 0; i--) {
            if (charArray[i] == '?') {
                boolean leftOrRight = charArray[i-1] == 'T';
                
                Character left = valStack.pop();
                Character right = valStack.pop();
                
                if (leftOrRight) {
                    valStack.push(left);
                }
                else {
                    valStack.push(right);
                }
                
                i--;
            }
            else if (charArray[i] == ':') {
                continue;
            }
            else {
                valStack.push(charArray[i]);
            }
        }
        
        return "" + valStack.pop();
    } 
    
    
    
    /*
    Divide original string into partitions, then calculated recursively.
    */
    public String parseTernary(String expression) {
        if(expression == null || expression.length() == 0){
            return expression;
        }
        char[] exp = expression.toCharArray();
        
        return DFS(exp, 0, exp.length - 1) + "";
        
    }
    public char DFS(char[] c, int start, int end){
        if(start == end){
            return c[start];
        }
        int count = 0, i =start;
        for(; i <= end; i++){
            if(c[i] == '?'){
                count ++;
            }else if (c[i] == ':'){
                count --;
                if(count == 0){
                    break;
                }
            }
        }
        return c[start] == 'T'? DFS(c, start + 2, i - 1) : DFS(c, i+1,end);
    }
}