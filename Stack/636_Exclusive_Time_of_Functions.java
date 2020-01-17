class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        List<int[]> logsPar = new ArrayList<>(logs.size());
        for (String log : logs) {
            String[] elements = log.split(":");
            logsPar.add(new int[] {Integer.parseInt(elements[0]), "start".equals(elements[1]) ? 0 : 1, 
                                  Integer.parseInt(elements[2])});
        }
        Collections.sort(logsPar, (a, b) -> {
            int diff = a[2] - b[2];
            if (diff == 0) {
                return a[1] - b[1];
            }
            return diff;
        });
        
        LinkedList<Integer> stack = new LinkedList<>();
        int[] ans = new int[n];
        int prev = 0;
        for (int[] log : logsPar) {
            if (log[1] == 0) {
                if (!stack.isEmpty()) {
                    ans[stack.peek()] += log[2] - prev;
                    prev = log[2];
                }
                stack.push(log[0]);
            }
            else {
                ans[stack.peek()] += log[2] + 1 - prev;
                prev = log[2] + 1;
                stack.pop();
            }
        }
        
        return ans;
    }
}