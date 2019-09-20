class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null) {
            return false;
        }
        
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] i1, int[] i2) {
                int endDiff = i1[1] - i2[1];
                if (endDiff == 0) {
                    return i1[0] - i2[0];
                }
                return endDiff;
            }
        });

        for (int i = 0; i < intervals.length; i++) {
            if (i > 0 && intervals[i][0] < intervals[i-1][1]) {
                return false;
            }
        }

        return true;
    }
}