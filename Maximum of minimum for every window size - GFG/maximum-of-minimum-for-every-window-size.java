// { Driver Code Starts
import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String[] inputline = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputline[0]);
            inputline = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputline[i]);
            }
            Solution ob =new Solution();
            int[] res = ob.maxOfMin(arr, n);
            
            for (int i = 0; i < n; i++) 
                System.out.print (res[i] + " ");
            System.out.println ();
        }
    }
}// } Driver Code Ends



class Solution 
{
    //Function to find maximum of minimums of every window size.
    static int[] maxOfMin(int[] arr, int n) 
    {
        int[] ans=new int[n+1];
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        int[] nsr=nextsmallerright(arr,n);
        int[] nsl=nextsmallerleft(arr,n);
        for(int i=0;i<n;i++){
            int l=nsr[i]-nsl[i]-1;
            ans[l]=Math.max(ans[l],arr[i]);
            
        }
        for(int i=n-1;i>=1;i--){
            ans[i]=Math.max(ans[i],ans[i+1]);
        }
       int[] ans_=new int[n];
       for(int i=1;i<=n;i++){
           ans_[i-1]=ans[i];
       }
        return ans_;
    }
    static int[] nextsmallerleft(int[] arr, int n){
        int[] ans=new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            while(st.size()>0 && arr[st.peek()]>=arr[i])st.pop();
            if(st.size()>0){
                ans[i]=st.peek();
            }    
            else ans[i]=-1;
            st.push(i);
    
        }
        return ans;
    } 
    static int[] nextsmallerright(int[] arr, int n){
        int[] ans=new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(st.size()>0 && arr[st.peek()]>=arr[i])st.pop();
            if(st.size()>0){
                ans[i]=st.peek();
            }    
            else ans[i]=n;
            st.push(i);
    
        }
        return ans;
    }
}