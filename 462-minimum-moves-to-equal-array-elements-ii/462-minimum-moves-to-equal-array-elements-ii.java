class Solution {
    public int minMoves2(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int avg=nums[(n-1)/2];
        int ans=0;
        for(int val:nums){
            ans+=Math.abs(avg-val);
        }
        return ans;
    }
}