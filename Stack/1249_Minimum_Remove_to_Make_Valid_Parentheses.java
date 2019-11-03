class Solution {
    public String minRemoveToMakeValid(String s) {
        LinkedList<Integer> idxStack = new LinkedList<>();
        Set<Integer> idxSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                idxStack.push(i);
            }
            else if (s.charAt(i) == ')') {
                if (idxStack.isEmpty()) {
                    idxSet.add(i);
                    continue;
                }
                idxStack.pop();
            }
        }

        while (!idxStack.isEmpty()) {
            idxSet.add(idxStack.poll());
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!idxSet.contains(i)) {
                ans.append(s.charAt(i));
            }
        }

        return ans.toString();
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(solution.minRemoveToMakeValid("a)b(c)d"));
        System.out.println(solution.minRemoveToMakeValid("))(("));
        System.out.println(solution.minRemoveToMakeValid("(a(b(c)d)"));
        System.out.println(solution.minRemoveToMakeValid("b(a))a()"));
        System.out.println(solution.minRemoveToMakeValid("b(a))a(("));
        System.out.println(solution.minRemoveToMakeValid("a)b(c)d"));
        System.out.println(solution.minRemoveToMakeValid("a)b()d"));
    }
}