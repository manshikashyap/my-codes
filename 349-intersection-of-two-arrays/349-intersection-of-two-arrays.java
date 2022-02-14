class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        ArrayList<Integer> aa= new ArrayList<>();
        
        for(int i=0;i<nums1.length;i++){
            hm.put(nums1[i],0);
        }
        for(int i=0;i<nums2.length;i++){
            if(hm.containsKey(nums2[i])){
               aa.add(nums2[i]);
                hm.remove(nums2[i]);
            }
        }
        int[] ans = new int[aa.size()];
        for(int i=0;i<ans.length;i++){
            ans[i]=aa.get(i);
        }
        return ans;
    }
}