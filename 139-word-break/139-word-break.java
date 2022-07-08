class Solution {
    public boolean wordBreak(String a, List<String> b) {
       boolean[] dp=new boolean[a.length()+1];
       dp[0]=true;
       for(int i=1;i<dp.length;i++){
           for(int j=0;j<i;j++){
               if(dp[j] && b.contains(a.substring(j,i))){
                   dp[i]=true;
                   break;
               }
           }
       }
       return dp[a.length()];
    }
}