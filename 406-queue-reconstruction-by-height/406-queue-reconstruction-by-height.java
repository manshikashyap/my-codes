
class Solution {
    public static void sortbyColumn(int arr[][], int col)
    {
        // Using built-in sort function Arrays.sort
       try{ Arrays.sort(arr, new Comparator<int[]>() {
            
          @Override              
          // Compare values according to columns
          public int compare(final int[] entry1, 
                             final int[] entry2) {
  
            // To sort in descending order revert 
            // the '>' Operator
            if (entry1[col] > entry2[col])
                return 1;
            else
                return -1;
          }
        }); } // End of function call sort().
        catch(IllegalArgumentException e){}
    }
    public int[][] reconstructQueue(int[][] arr) {
        int n=arr.length;   
        sortbyColumn(arr,0);
        int[][] ans=new int[n][2];
        for(int[] a:ans)Arrays.fill(a,-1);
        int count=0;
        for(int i=0;i<n;i++){
            count=arr[i][1];
            int idx=0;
            while(idx<n){
                if(ans[idx][0]==-1 && count==0){
                    ans[idx][0]=arr[i][0];
                    ans[idx][1]=arr[i][1];
                    break;
                }
                else if(ans[idx][0]==-1 || ans[idx][0]>=arr[i][0])count--;
                
                idx++;
            }
        }
        return ans;
    }
}