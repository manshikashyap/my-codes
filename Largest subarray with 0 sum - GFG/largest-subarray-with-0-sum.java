// { Driver Code Starts
import java.util.*;

class MaxLenZeroSumSub
{

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}// } Driver Code Ends


class GfG
{
    int maxLen(int arr[], int n)
    {
        // Your code here
      int sum=0;
      int l=0;
      HashMap<Integer,Integer> hm = new HashMap<>();
      for(int i=0;i<n;i++){
          sum+=arr[i];
          if(arr[i]==0&&l==0){
              l=1;
          }
          if(sum==0){
              l=i+1;
          }
          Integer prev=hm.get(sum);
          if(prev!=null){
              l=Math.max(l,i-prev);
          }
          else{
              hm.put(sum,i);
          }
      }
      return l;
    }
}