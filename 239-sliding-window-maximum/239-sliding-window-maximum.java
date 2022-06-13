class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int[] ans=new int[n-(k-1)];
        int []nge=ngr(nums,n);
        int i=0;
        for(int ws=0,we=k-1;we<n;we++,ws++){
            if(i<ws)i=ws;
            while(nge[i]<=we){
                i=nge[i];
            }
            ans[ws]=nums[i];
        }
        return ans;
    }
    
    public int[] ngr(int[] arr,int n){
        int[] ans=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            int val=arr[i];
            while(st.size()>0 && arr[st.peek()]<val)st.pop();
            if(st.size()==0)ans[i]=n;
            else ans[i]=st.peek();
            st.push(i);
        }
        return ans;
    }
}