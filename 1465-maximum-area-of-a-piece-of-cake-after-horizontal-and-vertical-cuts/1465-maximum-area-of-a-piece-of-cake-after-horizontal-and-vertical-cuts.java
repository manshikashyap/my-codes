class Solution {
    public int maxArea(int hi, int wi, int[] hz, int[] v) {
        long h=max(hz,hi);
        long w=max(v,wi);;
        return(int)(h * w % ((int)1e9 + 7));
    }
    public long max(int[] arr,int h){
        Arrays.sort(arr);
        int n=arr.length;
        long maxi=Math.max(arr[0],h-arr[n-1]);
        for(int i=1;i<n;i++){
            maxi=Math.max(maxi,arr[i]-arr[i-1]);
        }
        return maxi;
    }
}