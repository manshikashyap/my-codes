class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[]=new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for(int i=0;i<coins.length;i++){
            int coin=coins[i];
            for(int j=coin;j<=amount;j++){
                int req=j-coin;
                int val=dp[req]+1;
                dp[j]=Math.min(val,dp[j]);
            }
        }
        if(dp[amount]!=amount+1)return dp[amount];
        else return -1;
    }
}