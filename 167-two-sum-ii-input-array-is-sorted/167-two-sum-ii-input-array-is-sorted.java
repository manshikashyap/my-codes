class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n= numbers.length;
        int[] idx=new int[2];
        for(int i=0;i<n;i++){
            idx[0]=i+1;
            int req=target-numbers[i];
            int l=i+1;
            int h=n-1;
            while(l<=h){
                int mid=(l+h)/2;
                if(numbers[mid]==req){
                    idx[1]=mid+1;
                    return idx;
                }
                else if(numbers[mid]>req){
                    h=mid-1;
                }
                else{
                    l=mid+1;
                }
            }
            
        }
        
        return idx;
    }
}