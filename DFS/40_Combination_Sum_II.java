class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // sort candidates array
        Arrays.sort(candidates);
        
        // dfs
        List<List<Integer>> result = new LinkedList<>();
        helper(candidates, target, 0, new ArrayList<>(), result);
        
        return result;
    }
    
    private static void helper(int[] candidates, int target, int idx, List<Integer> combination, List<List<Integer>> result) {
        if (target == 0) {
            List<Integer> combinationPar = new LinkedList<>(combination);
            result.add(combinationPar);
        }
        
        for (int i = idx; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            
            // don't allow more than one same elements to be added into combination in a single for loop
            if (i > idx && candidates[i] == candidates[i-1]) {
                continue;
            }
            
            combination.add(candidates[i]);
            helper(candidates, target - candidates[i], i + 1, combination, result);
            combination.remove(combination.size() - 1);
        }
    }
}