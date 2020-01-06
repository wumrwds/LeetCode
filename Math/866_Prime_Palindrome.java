class Solution {
    public int primePalindrome(int N) {
        if (8 <= N && N <= 11) {
            return 11;
        }
        
        for (int i = 1; i < 100000; i++) {
            String high = Integer.toString(i);
            String low = new StringBuilder(high).reverse().substring(1).toString();
            Integer x = Integer.parseInt(high + low);
            if (x >= N && isPrime(x)) {
                return x;
            }
        }
        
        return -1;
    }
    
    private boolean isPrime(int x) {
        if (x < 2 || x % 2 == 0) {
            return x == 2;
        }
        
        for (int i = 3; i * i <= x; i += 2) {
            if (x % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}