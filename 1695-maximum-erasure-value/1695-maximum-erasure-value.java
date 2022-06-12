class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int l=0;
        int sum=0;
        int r=0;
        int max=0;
        int i=0;
        while(r<nums.length){
            if(hm.containsKey(nums[r])){
                l=Math.max(l,hm.get(nums[r])+1);
                while(i<l){
                    sum-=nums[i];
                    hm.remove(nums[i]);
                    i++;
                }
            }
            else{
                hm.put(nums[r],r);
                sum+=nums[r];
                max=Math.max(max,sum);
                r++;
            }
        }
        return max;
    }
}