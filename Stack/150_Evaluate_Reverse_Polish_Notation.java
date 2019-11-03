class Solution {
    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char TIMES = '*';
    private static final char DIVIDE = '/';

    public int evalRPN(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].length() > 1 || ('0' <= tokens[i].charAt(0) && tokens[i].charAt(0) <= '9')) {
                stack.push(Integer.valueOf(tokens[i]));
            }
            else {
                char ch = tokens[i].charAt(0);

                Integer num2 = stack.pop();
                Integer num1 = stack.pop();

                Integer result;
                switch(ch) {
                    case PLUS:
                        result = num1 + num2;
                        break;
                    case MINUS:
                        result = num1 - num2;
                        break;
                    case TIMES:
                        result = num1 * num2;
                        break;
                    case DIVIDE:
                        result = num1 / num2;
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + ch);
                }

                stack.push(result);
            }
        }

        return stack.peek();
    }
}