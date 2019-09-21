class Solution {
    private class Point implements Comparable<Point> {
        private boolean isLeft;
        private int val;
        
        private Point(boolean isLeft, int val) {
            this.isLeft = isLeft;
            this.val = val;
        }
        
        @Override
        public int compareTo(Point p) {
            int valDiff = this.val - p.val;
            if (valDiff == 0) {
                // **Note:** must let Right Point before Left Point while having same value
                // eg. [13,15],[1,13]  
                return this.isLeft && !p.isLeft ? 1 : -1;
            }
            return valDiff;
        }
    }
    
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length != 2) {
            return 0;
        }
        
        Point[] points = new Point[intervals.length * 2];
        for (int i = 0; i < intervals.length; i++) {
            points[2*i] = new Point(true, intervals[i][0]);
            points[2*i + 1] = new Point(false, intervals[i][1]);
        }
        
        Arrays.sort(points);
        
        int cnt = 0, max = 0;
        for (int i = 0; i < points.length; i++) {
            if (points[i].isLeft) {
                cnt++;
            }
            else {
                cnt--;
            }
            
            if (cnt > max) {
                max = cnt;
            }
        }
        
        return max;
    }
}