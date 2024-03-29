class Solution {
    public int combinationSum4(int[] nums, int target) {
        int n=nums.length;
        int dp[] = new int[target+1];
        dp[0]=1;
        for(int i=1;i<=target;i++){
            for(int num:nums){
                if(num<=i){
                    int req=i-num;
                    int ava=dp[req];
                    dp[i]+=ava;
                }
            }
        }
        return dp[target];
    }
}