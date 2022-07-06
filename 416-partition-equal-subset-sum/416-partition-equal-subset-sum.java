class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int num:nums)sum+=num;
        if(sum%2!=0)return false;
        sum=sum/2;
        boolean dp[][]=new boolean[n+1][sum+1];
        dp[0][0]=true;
        for(int i=1;i<=n;i++){
            int num=nums[i-1];
            for(int j=0;j<=sum;j++){
                if(j==0){
                    dp[i][j]=true;
                    continue;
                }
                boolean can=false;
                can=dp[i-1][j];
                if(can==false && num<=j){
                    int req=j-num;
                    can=dp[i-1][req];
                }
                dp[i][j]=can;
            }
        }
        return dp[n][sum];
    }
}