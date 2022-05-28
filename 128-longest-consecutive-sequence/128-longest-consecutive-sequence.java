class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        HashSet<Integer> h =new HashSet<>();
        for(int n : nums) {
            h.add(n);
        }
        for(int n : nums){
            if(!h.contains(n-1)){
                int l=1;
                int curr=n;
                while(h.contains(curr+1)){
                    l++;
                    curr++;
                }
                res=Math.max(res,l);
            }
        }
        return res;
    }
}