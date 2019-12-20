class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length != 2) {
            return new int[0][0];
        }
        
        List<int[]> ansList = new ArrayList<>();
        
        Arrays.sort(intervals, (a, b) -> {
            int diff = a[0] - b[0];
            
            if (diff == 0) {
                return a[1] - b[1];
            }
            
            return diff;
        });
        
        ansList.add(new int[]{intervals[0][0], intervals[0][1]});
        for (int i = 0; i < intervals.length - 1; i++) {
            int[] cur = ansList.get(ansList.size() - 1);
            if (cur[1] >= intervals[i+1][0]) {
                cur[1] = Math.max(cur[1], intervals[i+1][1]);
            }
            else {
                ansList.add(new int[]{intervals[i+1][0], intervals[i+1][1]});
            }
        }
        
        int[][] ans = new int[ansList.size()][2];
        for (int i = 0; i < ansList.size(); i++) {
            ans[i][0] = ansList.get(i)[0];
            ans[i][1] = ansList.get(i)[1];
        }
            
        return ans;
    }
}