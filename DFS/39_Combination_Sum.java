class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // sort candidates array
        Arrays.sort(candidates);
        
        // dfs
        List<List<Integer>> result = new LinkedList<>();
        helper(candidates, target, 0, new ArrayList<>(), result);
        
        return result;
    }
    
    private static void helper(int[] candidates, int target, int idx, List<Integer> combination, List<List<Integer>> result) {
        if (target == 0) {
            List<Integer> combinationPar = new LinkedList(combination);
            result.add(combinationPar);
        }
        
        for (int i = idx; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            
            combination.add(candidates[i]);
            helper(candidates, target - candidates[i], i, combination, result);
            combination.remove(combination.size() - 1);
        }
    }
}