class Solution {
    public int maxProfit(int[] arr) {
        int n= arr.length;
        int dp[][] = new int[n][2];
        dp[0][0]=0-arr[0];
        dp[0][1]=0;
        for(int i=1;i<n;i++){
            if(dp[i-1][0]>0-arr[i]){
                dp[i][0]=dp[i-1][0];
            }
            else{
                dp[i][0]=0-arr[i];
            }
            if(dp[i-1][1]>arr[i]+dp[i][0]){
                dp[i][1]=dp[i-1][1];
            }
            else{
                dp[i][1]=dp[i][0]+arr[i];
            }
        }
        return dp[n-1][1];
    }
}