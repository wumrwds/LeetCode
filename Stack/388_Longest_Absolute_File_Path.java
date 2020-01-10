class Solution {
    public int lengthLongestPath(String input) {
        String[] components = input.split("\n");
        
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(0);
        int maxLen = 0, level = 1;
        for (String component : components) {
            int charOfTab = component.lastIndexOf("\t") + 1;
            int startIdx = component.contains("\t") ? component.lastIndexOf("\t") : 0;
            level = charOfTab + 1;
            
            while (level < stack.size()) {
                stack.pop();
            }
            
            int curLen = stack.peek() + component.length() - charOfTab;
            if (level > 1) {
                curLen++;
            }
            stack.push(curLen);
            
            // System.out.println(stack.peek() + ", " + level);
            
            int lastPeriodIdx = component.lastIndexOf(".");
            if (lastPeriodIdx > 0 && maxLen < curLen) {
                maxLen = curLen;
            }
        }
        
        return maxLen;
    }
}