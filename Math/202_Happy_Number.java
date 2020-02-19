class Solution {
    /*
    have cycle or end at 1.
    */
    public boolean isHappy(int n) {
        Set<Integer> hashset = new HashSet<>();
        while (n != 1) {
            if (hashset.contains(n)) {
                return false;
            }

            hashset.add(n);
            
            int newN = 0;
            while (n > 0) {
                newN += (n % 10) * (n % 10);
                n /= 10;    
            }
            
            n = newN;
        }
        
        return true;
    }
}