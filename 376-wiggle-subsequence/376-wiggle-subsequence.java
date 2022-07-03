class Solution {
    public int wiggleMaxLength(int[] nums) {
        boolean mark=false;
        int m=nums.length;
        int n=nums.length;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]<nums[i+1]&& !mark){
                mark=true;
            }
            else if(nums[i]>nums[i+1] && mark){
                mark=false;
            }
            else m--;
        }
        mark=false;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1] && !mark){
                mark=true;
            }
            else if(nums[i]<nums[i+1] && mark){
                mark=false;
            }
            else n--;
        }
        return Math.max(m,n);
    }
}