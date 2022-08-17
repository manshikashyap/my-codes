class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int[] ans=new int[2];
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            int req=target-nums[i];
            if(hm.containsKey(req)&&i!=hm.get(req)){
                ans[0]=i;
                ans[1]=hm.get(req);
                break;
            }
        }
        return ans;
    }
}