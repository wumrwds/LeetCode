class Solution {
    /*
    dp[i] => the minimum steps to display i
    
    dp[i] = min(dp[i/2], dp[i+1]) + 1     (i+2 must be an even number)
          = X - i               , i <= X
          
    But it seems that it's not a good transition equation for dp, since the lower state will depend on higher state.
    
    So we can consider greedy. Since the calculator only con do double and decrement actions and decrement in high
    value level must cost more than do decrement in the low value level. (double action will amplify the distance)
    
    Thus, we our strategy is always to do decrement first. So for an odd Y, we increase it by one then divide by 2,
    for an even Y, we just divide it by 2. Do recursively until Y is less than X, then do the rest decrement actions
    to reduce X to Y.
    */
    public int brokenCalc(int X, int Y) {
        int cnt = 0;
        while (X < Y) {
            if (Y % 2 == 1) {
                Y++;
                cnt++;
            }
            
            Y /= 2;
            cnt++;
        }
        
        return cnt + X - Y;
    }
}