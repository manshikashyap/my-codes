class Solution {
    public int jump(int[] arr) {
        int n = arr.length;
         Integer dp[] = new Integer[n];
        dp[n-1]=0;
        for(int i =n-2;i>=0;i--){
            if(arr[i]>0){
                int min = Integer.MAX_VALUE;
                for(int j=1;j<=arr[i] && j+i<n;j++){
                    if(dp[i+j] != null)
                   {
                        min = Math.min(min,dp[i+j]);
                   }
                }
                if(min!=Integer.MAX_VALUE)
                   dp[i]=min+1;
            }
            
        }
    
            return dp[0];
           
        
    }
}