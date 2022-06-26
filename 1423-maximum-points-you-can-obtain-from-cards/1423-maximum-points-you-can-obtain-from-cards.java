class Solution {
    public int maxScore(int[] arr, int k) {
        int sum=0;
        int ans=0;
        int csum=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            sum+=arr[i];
        }
        if(n==k)return sum;
        for(int i=0;i<n-k;i++){
            csum+=arr[i];
        }
        int minsum=csum;
        for(int i=n-k;i<n;i++){
            csum+=arr[i];
            csum-=arr[i-(n-k)];
            minsum=Math.min(minsum,csum);
            
        }
        return sum-minsum;
    }
}