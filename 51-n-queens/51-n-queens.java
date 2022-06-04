class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans= new ArrayList<List<String>>();
        int[][] dp=new int[n][n];
       // List<String> qsf= new ArrayList<String>();
        nqueens(ans,dp,0);
        return ans;
    }
    
    public void nqueens(List<List<String>> ans ,int[][] dp,int r){
        if(r==dp.length){
            List<String> qsf= new ArrayList<String>();
            for(int i=0;i<dp.length;i++){
                String s="";
                for(int j=0;j<dp[0].length;j++){
                    if(dp[i][j]==1)s+='Q';
                    else s+='.';
                }
                qsf.add(s);
            }
            ans.add(qsf);
            return;
        }
        for(int j =0; j<dp.length; j++)
        {
            if(issafe(dp,r,j))
            {
                dp[r][j]=1;
                nqueens(ans,dp,r+1);
                dp[r][j]=0;
            }
        }
    }
    
    public boolean issafe(int[][] dp,int r,int c){
        for(int i=r-1;i>=0;i--){
            if(dp[i][c]==1)return false;
        }
        for(int i=r-1,j=c+1;i>=0&&j<dp.length;i--,j++){
            if(dp[i][j]==1)return false;
        }
        for(int i=r-1,j=c-1;i>=0 && j>=0;i--,j--){
            if(dp[i][j]==1)return false;
        }
        return true;
    }
}