class Solution {
    int ans=0;
    public int totalNQueens(int n) {
        int dp[][]=new int[n][n];
        nqueens(dp,0);
        return ans;
    }
    
    public void nqueens(int dp[][],int r){
        if(r==dp.length){
            ++ans;
            return;
        }
        for(int i=0;i<dp.length;i++){
            if(ispossible(dp,r,i)){
                dp[r][i]=1;
                nqueens(dp,r+1);
                dp[r][i]=0;
            }
        }
    }
    
    public boolean ispossible(int[][] dp,int r,int c){
        for(int i=r-1; i>=0; i--)
        {
            if(dp[i][c]==1)
            {
                return false;
            }
        }
        
        for(int i=r-1,j=c-1; i>=0 && j>=0; i--,j--)
        {
            if(dp[i][j]==1)
            {
                return false;
            }
        }
        
        for(int i=r-1,j=c+1; i>=0 && j<=dp.length-1; i--,j++)
        {
            if(dp[i][j]==1)
            {
                return false;
            }
        }
        
       
        return true;
    }
}