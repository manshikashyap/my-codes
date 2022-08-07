class Solution {
    int mod=(int)1e9+7;
    public int countVowelPermutation(int n) {
        int[] dp=new int[5];
        int res=0,a,e,i,o,u;
        Arrays.fill(dp,1);
        for(int j=0;j<n-1;j++){
            a=e=i=o=u=0;
            e=dp[0];
            i=a=dp[1];
            a=(a+dp[2])%mod;
            e=(e+dp[2])%mod;
            o=(o+dp[2])%mod;
            u=(u+dp[2])%mod;
            i=(i+dp[3])%mod;
            u=(u+dp[3])%mod;
            a=(a+dp[4])%mod;
            dp[0]=a;
            dp[1]=e;
            dp[2]=i;
            dp[3]=o;
            dp[4]=u;
        }
        for(int j=0;j<dp.length;j++)res=(res+dp[j])%mod;
        return res;
    }
}