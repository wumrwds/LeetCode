class Solution {
    // 1 2 3 4 5 6 8
    // 1*2 1*3 2*2 1*5 2*3 2*4 3*3 2*5 3*4 3*5
    // dp[i] = min(max(2) * 2, max(3) * 3, max(5) * 5)
    public int nthUglyNumber(int n) {
        List<Integer> seq = new ArrayList<>(n);
        seq.add(1);
        
        int cur2Idx = 0, cur3Idx = 0, cur5Idx = 0;
        
        for (int i = 1; i < n; i++) {
            int cur2 = seq.get(cur2Idx), cur3 = seq.get(cur3Idx), cur5 = seq.get(cur5Idx);
            
            if (cur2 * 2 == seq.get(seq.size()-1)) {
                cur2Idx++;
                cur2 = seq.get(cur2Idx);
            }
            
            if (cur3 * 3 == seq.get(seq.size()-1)) {
                cur3Idx++;
                cur3 = seq.get(cur3Idx);
            }
            
            if (cur5 * 5 == seq.get(seq.size()-1)) {
                cur5Idx++;
                cur5 = seq.get(cur5Idx);
            }
            
            if (cur2 * 2 < cur3 * 3) {
                if (cur2 * 2 < cur5 * 5) {
                    // cur2 * 2 is the least
                    seq.add(cur2*2);
                    cur2Idx++;
                }
                else {
                    // cur5 * 5 is the least
                    seq.add(cur5*5);
                    cur5Idx++;
                }
            }
            else {
                // cur2 * 2 > cur3 * 3
                if (cur3 * 3 < cur5 * 5) {
                    // cur3 * 3 is the least
                    seq.add(cur3*3);
                    cur3Idx++;
                }
                else {
                    // cur5 * 5 is the least
                    seq.add(cur5*5);
                    cur5Idx++;
                }
            }
        }
        
        // System.out.println(seq);
        
        return seq.get(n-1);
    }
    
}



/*

A better way to solve this question is:

public class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for(int i=1;i<n;i++){
            int min = Math.min(Math.min(factor2,factor3),factor5);
            ugly[i] = min;
            if(factor2 == min)
                factor2 = 2*ugly[++index2];
            if(factor3 == min)
                factor3 = 3*ugly[++index3];
            if(factor5 == min)
                factor5 = 5*ugly[++index5];
        }
        return ugly[n-1];
    }
}

*/