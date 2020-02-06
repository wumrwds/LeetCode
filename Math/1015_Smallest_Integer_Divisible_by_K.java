class Solution {
    /*
    Why only iterating from [1, K]? Why not 2 and 5?
    - Suppose we have two 11..11 number a & b which have the same remainder by K,
      so a % k = b % k  and  a - b = 111..10000 (a-b ones & b zeros) => (a - b) % k = 0
      Since we have iterated to a, a must be larger than a - b, so the left part 111...1
      (a - b ones) in 11..000, can not be divided by K, so now we only remain the right
      part 1000..0 (b zeros). 1000..0 (b zeros) only have two factors: 2 & 5. So if K is
      not multiple of 2 and 5, there can not be the case that has same remainders.
    */
    public int smallestRepunitDivByK(int K) {
        if (K % 2 == 0 || K % 5 == 0) {
            return -1;
        }
        
        int remainder = 0;
        for (int i = 1; i <= K; i++) {
            remainder = (10 * remainder + 1) % K;
            if (remainder == 0) {
                return i;
            }
        }
        
        // can not be reached
        return -1;
    }
}