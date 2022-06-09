class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n= numbers.length;
        int[] idx=new int[2];
        int l=0;
        int h=n-1;
        while(l<h){
           int sum=numbers[l]+numbers[h];
            if(sum==target){
                idx[0]=l+1;
                idx[1]=h+1;
                return idx;
            }
            else if(sum<target)l++;
            else h--;
        }
        
        return idx;
    }
}