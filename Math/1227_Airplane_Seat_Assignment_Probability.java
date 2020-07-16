class Solution {
    /*
    f(n) = 1/n * 1 + (n-2)/n * [(1/(n-2))*f(n-1) + (1/(n-2)) * f(n-2) + ... + (1/(n-2)) * f(2)] + 1/n * 0
          take 1.                  take 2              take 3                       take n-1.     take n
         = 1/n * [f(n-1) + f(n-2) + ... + f(1)] 
         
    let f(n) - f(n-1), we can get f(n-1) = f(n) when n > 1
    when n = 1, f(1) = 1
    when n = 2, f(2) = 1/2 * 1 = 0.5
    when n = 3, f(3) = f(2)
    */
    public double nthPersonGetsNthSeat(int n) {
        if (n > 1) {
            return 0.5;
        }
        
        return 1.0;
    }
}