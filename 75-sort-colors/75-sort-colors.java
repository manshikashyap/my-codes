class Solution {
    public void sortColors(int[] arr) {
        int i=0;
        int j=arr.length-1;
        int k=0;
        while(i<=j){
            if(arr[i]==0){
                int temp=arr[i];
                arr[i]=arr[k];
                arr[k]=temp;
                i++;
                k++;
            }
            else if(arr[i]==2){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                j--;
            }
            else{
                i++;
            }
        }
    }
}