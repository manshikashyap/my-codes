class Solution {
    public int findMin(int[] arr) {
        for(int i=0;i<arr.length-1;i++){
            if(arr[i+1]<arr[i]){
                return arr[i+1];
            }
        }
        return arr[0];
    }
}