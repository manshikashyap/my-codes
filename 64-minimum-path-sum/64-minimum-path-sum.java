class Solution {
    public int minPathSum(int[][] cost) {
        int n= cost.length;
        int m =cost[0].length;
         int[][] qb = new int[n][m];
        for(int i = n-1;i>=0;i--){
            for(int j = m-1;j>=0;j--){
                if(i==n-1 && j == m-1){
                    qb[i][j]=cost[i][j];
                }
                else if(i==n-1 ){
                    qb[i][j]=cost[i][j]+qb[i][j+1];
                    
                }
                else if(j==m-1){
                    qb[i][j]=cost[i][j]+qb[i+1][j];
                }
                else{
                    int val = qb[i][j+1];
                    int val1=qb[i+1][j];
                    int ans = Math.min(val,val1);
                    qb[i][j]=cost[i][j]+ans;
                }
            }
        }
        return qb[0][0];
    }
}