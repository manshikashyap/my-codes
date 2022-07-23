class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n=nums.length;
        int[] res=new int[n];
        int arr[][]=new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=nums[i];
            arr[i][1]=i;
        }
        sort(arr,res,0,n-1);
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++)ans.add(res[i]);
        return ans;
    }
    public void sort(int[][] arr,int[] res,int l,int r){
        if(l<r){
            int m=(l+r)/2;
            sort(arr,res,l,m);
            sort(arr,res,m+1,r);
            merge(arr,res,l,m,r);
        }
    }
    public void merge(int[][] arr,int[] res,int l,int m,int r){
        int[][] left=Arrays.copyOfRange(arr, l, m+1);
        int[][] right=Arrays.copyOfRange(arr, m+1, r+1);
        int i=0;
        int j=0;
        int k=l;
        int c=0;
        while(i<left.length && j<right.length){
            if(left[i][0]<=right[j][0]){
                res[left[i][1]]+=c;
                arr[k++]=left[i++];
            }
            else{
                c++;
                arr[k++]=right[j++];
            }
        }
        while(i<left.length){
            res[left[i][1]]+=c;
            arr[k++]=left[i++];
        }
        while(j<right.length){
            arr[k++]=right[j++];
        }
    }
}