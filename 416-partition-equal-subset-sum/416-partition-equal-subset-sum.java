class Solution {
    public boolean canPartition(int[] arr) {
     int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        if(sum%2 != 0){
            return false;
        }
        sum=sum/2;
        
        boolean dp[][] = new boolean[arr.length+1][sum+1];
        dp[0][0] =true;
        for(int i=1;i<=arr.length;i++){
            int num=arr[i-1];
            for(int j=0;j<=sum;j++){
                if(j==0){
                    dp[i][j]=true;
                    continue;
                }
              boolean can = false;
              if(i>0){
                  can=dp[i-1][j];
              }  
              if(can==false && num<=j && i>0){
                  int req=j-num;
                  can=dp[i-1][req];
              }
                dp[i][j]=can;
            }
        }
        return dp[arr.length][sum];
    }
}