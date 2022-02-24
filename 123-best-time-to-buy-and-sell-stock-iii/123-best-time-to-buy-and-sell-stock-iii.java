class Solution {
    public int maxProfit(int[] arr) {
        int n= arr.length;
        int buy =arr[0];
        int[] qb = new int[n];
        for(int i=1;i<n;i++){
            buy = Math.min(buy,arr[i]);
            qb[i]=Math.max(qb[i-1],arr[i]-buy);
        }
        int[] dp = new int[n];
        int sell = arr[n-1];
        dp[n-1]=0;
        for(int i = n-2;i>=0;i--){
            sell =Math.max(sell,arr[i]);
            dp[i]=Math.max(dp[i+1],sell-arr[i]);
        }
        int[] ans = new int[n];
        for(int i =0;i<n;i++){
            ans[i]=qb[i]+dp[i];
        }
        int max=ans[0];
        for(int i=1;i<n;i++){
            max = Math.max(max,ans[i]);
        }
        return max;
    }
}