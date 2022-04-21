class Solution {
    public int minOperations(int n) {
     /*   if(n==1)return 0;
        int[] arr= new int[n];
        for(int i=0;i<n;i++){
            arr[i]=(2*i)+1;
        }
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
        }
        int target=sum/n;
        int x=0;
        int y=n-1;
        int ans=0;
        while(x<y){
            if(arr[x]!=arr[y]){
                arr[x]+=1;
                arr[y]-=1;
            }
            
            ans++;
            if(arr[x]==target && arr[y]==target){
                x++;
                y--;
            }
        }
        return ans;
        */
        return n*n/4;
    }
}