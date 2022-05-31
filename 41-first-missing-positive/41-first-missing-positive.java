class Solution {
    public int firstMissingPositive(int[] nums) {
        /*int n=arr.length;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int miss=0;
        for(int i=0;i<n;i++){
            if(arr[i]>0 && arr[i]<min){
                min=arr[i];
            }
            if(arr[i]>0 && arr[i]>max){
                max=arr[i];
            }
            
        }
        if(min!=1)return 1;
        else if(){
            
        }
        else{
            return max+1;
        }
        */
        int[] arr = new int[nums.length+1];
        for(int num: nums) {
            if(num>=0 && num<=nums.length) {
                arr[num]++;
            }
        }
        int i=1;
        for(i = 1; i<arr.length; i++) {
            if(arr[i]==0) {
                return i;
            }
        }
        return i;
    }
}