class Solution {
    private int findLongest(int[] nums){
        boolean higher = false;
        int output1 = nums.length, output2 = nums.length;
        
           for(int i = 0;i<nums.length-1;i++){
            if(nums[i] > nums[i+1] && higher == false){
                higher = true;
            }else if(nums[i] < nums[i+1] && higher == true){
                higher = false;
            }else {
                output1--;
            }
        }
        higher = false;
       
                 for(int i = 0;i<nums.length-1;i++){
            if(nums[i] < nums[i+1] && higher == false){
                higher = true;
            }else if(nums[i] > nums[i+1] && higher == true){
                higher = false;
            }else {
                output2--;
            }
        }    
            
       return Math.max(output1,output2) ;
       
        
        
    }
    public int wiggleMaxLength(int[] nums){
      
        return findLongest(nums);
    }
}