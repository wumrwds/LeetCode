class Solution {
    public String[] expand(String S) {
        String[] partitions = S.split("\\{|\\}");
        
        List<String> res = new LinkedList<>();
        dfs(partitions, 0, "", res);
        
        return res.toArray(new String[0]);
    }
    
    private void dfs(String[] partitions, int idx, String cur, List<String> result) {
        if (idx == partitions.length) {
            result.add(cur);
            return;
        }

        String[] candidates = partitions[idx].split(",");
        Arrays.sort(candidates);
        for (String candidate : candidates) {
            dfs(partitions, idx + 1, cur + candidate, result);
        }
    }
}