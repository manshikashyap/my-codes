class Solution {
    public int minInsertions(String s) {
        int n= s.length();
        StringBuilder str=new StringBuilder(s);
        str.reverse();
        int res=lcs(s,str.toString(),n);
        return n-res;
    }
    
    public int lcs(String s,String s1,int n){
        int dp[][] = new int[n+1][n+1];
        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(s.charAt(i)==s1.charAt(j)){
                    dp[i][j]=dp[i+1][j+1]+1;
                }
                else{
                    dp[i][j]=Math.max(dp[i][j+1],dp[i+1][j]);
                }
            }
        }

        return dp[0][0];
        
    }
}