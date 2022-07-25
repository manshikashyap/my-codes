class Solution {
    public int[] searchRange(int[] nums, int target) {
        int ans[]=new int[2];
        int f=-1;
        int ls=-1;
        int l=0;
        int h=nums.length-1;
        while(l<=h){
            int m=(l+h)/2;
            if(target==nums[m]){
                f=m;
                h=m-1;
            }
            else if(target>nums[m]){
                l=m+1;
            }
            else{
                h=m-1;
            }
        }
        l=0;
        h=nums.length-1;
        while(l<=h){
            int m=(l+h)/2;
            if(target==nums[m]){
                l=m+1;
                ls=m;
            }
            else if(target>nums[m]){
                l=m+1;
            }
            else{
                h=m-1;
            }
        }
        ans[0]=f;
        ans[1]=ls;
        return ans;
    }
}