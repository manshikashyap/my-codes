class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans=new int[nums1.length];
        HashMap<Integer,Integer> hm = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        hm.put(nums2[nums2.length-1],-1);
        st.push(nums2[nums2.length-1]);
        for(int i=nums2.length-2;i>=0;i--){
            int val= nums2[i];
            while(st.size()>0 && st.peek()<val){
                st.pop();
            }
           if(st.size()==0){
                hm.put(val,-1);
            }
            else{
                hm.put(val,st.peek());
            }
            st.push(val);
        }
        for(int i=0;i<nums1.length;i++){
            ans[i]=hm.get(nums1[i]);
        }
        return ans;
    }
}