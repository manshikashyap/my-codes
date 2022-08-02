class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length;
        int low=matrix[0][0];
        int high=matrix[n-1][n-1];
        while(low<high){
            int mid= low + (high - low)/2;
            int c=helper(matrix,mid);
            if(c<k)low=mid+1;
            else high=mid;
        }
        return low;
    }
    public int helper(int[][] matrix, int t){
        int c=0;
        int l=matrix.length;
        int i=l-1;
        int j=0;
        while(i>=0 && j<l){
            if(matrix[i][j]>t)i--;
            else{
                c+=(i+1);
                j++;
            }
        }
        return c;
    }
}