class Solution {
    public int lengthOfLIS(int[] arr) {
        int ans=0;
        int n=arr.length;
        if(n==1)return 1;
        int dp[] = new int[n];
        dp[0]=1;
        for(int i=1;i<n;i++){
            int max=0;
            for(int j =0;j<i;j++){
               if(arr[j]<arr[i]){
                    if(dp[j]>max){
                    max=dp[j];
                }
               }
            }
            dp[i]=max+1;
            ans=Math.max(dp[i],ans);
        }
         return ans;
    }
   
}