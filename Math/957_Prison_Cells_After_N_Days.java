class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        int cycle = 0;
        int[] curDay = cells;
        
        // we don't add the init state into the hashset, so that we can calculate the cycle correctly
        // case 1: the initial state is a state of the cycle
        //         0 - 1 - 2 - 0 - 1 - 2 ...  => cycle = 3
        // case 2: the initial state is not a state of the cycle
        //         0 - 1 - 2 - 1 - 2 - 1 ...  => cycle = 2
        HashSet<String> hashSet = new HashSet<>();
        while (true) {
            int[] nextDay = nextDay(curDay);
            String key = Arrays.toString(nextDay);
            
            if (hashSet.contains(key)) {
                break;
            }
            
            cycle++;
            curDay = nextDay;
            hashSet.add(key);
        }
        
        // skip the useless rounds
        N %= cycle;
        for (int i = 0; i < N; i++) {
            curDay = nextDay(curDay);
        }
        
        return curDay;
    }
    
    private int[] nextDay(int[] cells) {
        int n = cells.length;
        int[] nextDay = new int[n];
        for (int i = 1; i < n - 1; i++) {
            nextDay[i] = cells[i-1] == cells[i+1] ? 1 : 0;
        }
        return nextDay;
    }
}