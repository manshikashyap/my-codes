class Solution {
    public int minCost(int n, int[] arr) {
        int[] a= new int[arr.length+2];
        Arrays.sort(arr);
        int[][] dp=new int[arr.length+1][arr.length+1];
        for(int[] row:dp)Arrays.fill(row,-1);
        a[0]=0;
        a[a.length-1]=n;
        for(int i=1;i<a.length-1;i++)a[i]=arr[i-1];
        return helper(1,a.length-2,a,dp);
    }
    public int helper(int i,int j,int[] arr,int[][] dp){
        if(i>j)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int mini=Integer.MAX_VALUE;
        for(int idx=i;idx<=j;idx++){
            int cost=arr[j+1]-arr[i-1]+helper(i,idx-1,arr,dp)+helper(idx+1,j,arr,dp);
            mini=Math.min(mini,cost);
        }
        dp[i][j]=mini;
        return mini;
    }
}