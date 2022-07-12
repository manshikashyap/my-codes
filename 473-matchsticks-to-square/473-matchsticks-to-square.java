class Solution {
    public boolean makesquare(int[] arr) {
        if(arr.length<4)return false;
        int n=arr.length;
        if(n==4){
            for(int i=0;i<n-1;i++){
                if(arr[i]!=arr[i+1])return false;
            }
        }    
        int sum=0;
        for(int val:arr)sum+=val;
        if(sum%4!=0)return false;
        int side=sum/4;
        int[] sides=new int[]{side,side,side,side};
        Arrays.sort(arr);
        return helper(arr,n-1,sides);
    }
        public boolean helper(int[] arr,int i,int[] sides){
            if(i==-1){
                return sides[0]==0 && sides[1]==0 && sides[2]==0 && sides[3]==0;
            }

            for(int j=0;j<4;j++){
                if(arr[i]>sides[j])continue;
                sides[j]-=arr[i];
                if(helper(arr,i-1,sides))return true;
                sides[j]+=arr[i];
            }
            return false;
        }
    
}