class Solution {
    /*
    [0, 0]  2  true     [0]   2  false
    [1,0,0] 2 true     [1,0] 2 false
    [1,2,3] 6 true
    */
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        
        Map<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, -1);
        
        int prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            
            int modPrefixSum = k == 0 ? prefixSum : prefixSum % k;
            
            if (hashMap.containsKey(modPrefixSum)) {
                if (i - hashMap.get(modPrefixSum) > 1) {
                    return true;
                }
            }
            else {
                hashMap.put(modPrefixSum, i);
            }
        }
        
        return false;
    }
}