class Solution {
    public int largestRectangleArea(int[] heights) {
        int left[]=nsl(heights);
        int[] right=nsr(heights);
        int maxa=0;
        for(int i=0;i<heights.length;i++){
            int w=right[i]-left[i]-1;
            int area=w*heights[i];
            maxa=Math.max(maxa,area);
        }
        return maxa;
    }
    public int[] nsr(int []arr){
        int[] ans=new int[arr.length];
        Stack<Integer> st=new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            int val=arr[i];
            while(st.size()>0 && arr[st.peek()]>=val)st.pop();
            if(st.size()==0)ans[i]=arr.length;
            else
                ans[i]=st.peek();
            st.push(i);
        }
        return ans;
    }
    public int[] nsl(int []arr){
        int[] ans=new int[arr.length];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<arr.length;i++){
            int val=arr[i];
            while(st.size()>0 && arr[st.peek()]>=val)st.pop();
            if(st.size()==0)ans[i]= -1;
            else
                ans[i]=st.peek();
            st.push(i);
        }
        return ans;
    }
}