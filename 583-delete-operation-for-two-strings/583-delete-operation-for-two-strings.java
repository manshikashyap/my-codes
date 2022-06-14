class Solution {
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m= word2.length();
        int[][] dp= new int[n+1][m+1];
            for(int i=n-1;i>=0;i--){
                for(int j=m-1;j>=0;j--){
                    char c1=word1.charAt(i);
                    char c2=word2.charAt(j);
                    if(c1==c2){
                        dp[i][j]=dp[i+1][j+1]+1;
                    }
                    else{
                        dp[i][j]=Math.max(dp[i][j+1],dp[i+1][j]);
                    }
                }
            }
        return m+n-(2*dp[0][0]);
    }
}