class Solution {
    public boolean checkPossibility(int[] nums) {
        int chng=0;
        for(int i=1;i<nums.length && chng<=1 ;i++){
            if(nums[i]<nums[i-1]){
                chng++;
                if(i-2<0 || nums[i-2]<=nums[i])nums[i-1]=nums[i];
                else nums[i]=nums[i-1];
                
            }
        }
        if(chng>1)return false;
        return true;
    }
}