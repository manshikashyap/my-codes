class Solution {
    public boolean canJump(int[] nums) {
  int n = nums.length;
        
        int maxIdx = 0;
        
        for(int i = 0; i <= maxIdx; i++)
        {
            if(maxIdx  >= n-1)
                return true;
            
            maxIdx = Math.max(maxIdx, i + nums[i]);
        }
        
        return false;
    }
}