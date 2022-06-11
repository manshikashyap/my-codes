class Solution {
    public int minOperations(int[] nums, int x) {
        int n= nums.length;
        int sum=0;
        for(int i=0;i<n;i++)sum+=nums[i];
        int csum=0;
        int maxl=-1;
        for(int l=0,r=0;r<n;r++){
            csum+=nums[r];
            while(l<=r && csum>sum-x )csum-=nums[l++];
            if(csum==sum-x)maxl=Math.max(maxl,r-l+1);
        }
        return maxl == -1?-1 :n-maxl;
        
    }
}