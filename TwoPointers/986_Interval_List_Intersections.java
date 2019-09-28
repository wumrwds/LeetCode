package top.wumrwds;


import java.util.ArrayList;
import java.util.List;

/**
 * 986. Interval List Intersections
 *
 * @author wumrwds
 */
public class Solution {

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> results = new ArrayList<>();

        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            // get min(end) & max(start)
            int minEnd = Math.min(A[i][1], B[j][1]);
            int maxStart = Math.max(A[i][0], B[j][0]);

            if (minEnd >= maxStart) {
                // if the two head elements intersect, output the intersection interval
                int[] tmp = new int[2];
                tmp[0] = maxStart;
                tmp[1] = minEnd;
                results.add(tmp);
            }

            // pop the interval with the less end
            if (A[i][1] < B[j][1]) {
                i++;
            }
            else if (A[i][1] >= B[j][1]) {
                j++;
            }
        }

        return results.toArray(new int[0][0]);
    }


    public static void main(String[] args) {

        System.out.println(new Solution().intervalIntersection(new int[][]{{0,2},{5,10},{13,23},{24,25}}, new int[][]{{1,5},{8,12},{15,24},{25,26}}));
        System.out.println(new Solution().intervalIntersection(new int[][]{{0,20}, {22,25}}, new int[][]{{1,5},{8,12},{15,24},{25,26}}));
    }
}