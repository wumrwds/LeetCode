//递归式dp[i] = min(dp[i-coins[j]]) + 1

//这个的思路就是如果压根没有用过之前的dp[]（就是说减了coin之后全都小于0了）
//或是用了然而用的那些也全都是无效的dp[]，那么就也写成无效

//无效的标志设为INT_MAX
//dp[0]要设置成0，因为会被用到，比如coin里有5， dp[5]求的时候就会用到

class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        int dp[100010];
        dp[0] = 0;
        for(int i = 1; i <= amount; i++){
            int Min = INT_MAX;
            for(int j = 0; j < coins.size(); j++){
                if(i - coins[j] < 0)    continue;
                if(dp[i-coins[j]] < Min)
                    Min = dp[i-coins[j]];
            }
            if(Min == INT_MAX)  dp[i] = Min;
            else dp[i] = Min + 1;
        }
        return dp[amount] == INT_MAX ? -1 : dp[amount];
    }
};
