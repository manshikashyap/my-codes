// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String args[]) {
        // taking input using class Scanner
        Scanner sc = new Scanner(System.in);

        // taking total count of testcases
        int t = sc.nextInt();

        while (t-- > 0) {
            // taking total number of elements
            int n = sc.nextInt();

            // taking size of subArrays
            int k = sc.nextInt();

            // Declaring and Intializing an array of size n
            int arr[] = new int[n];

            // adding all the elements to the array
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            // Calling the method max_of_subarrays of class solve
            // and storing the result in an ArrayList
            ArrayList<Integer> res = new Solution().max_of_subarrays(arr, n, k);

            // printing the elements of the ArrayList
            for (int i = 0; i < res.size(); i++)
                System.out.print(res.get(i) + " ");
            System.out.println();
        }
    }
}// } Driver Code Ends


class Solution {
    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
        ArrayList<Integer> ans= new ArrayList<>();
        int[] ngr=nextgreater(arr,n);
        int idx=0;
        for(int ws=0,we=k-1;we<n;we++,ws++){
            if(idx<ws)idx=ws;
            while(ngr[idx]<=we){
                idx=ngr[idx];
            }
            ans.add(arr[idx]);
        }
        return ans;
        
    }
    
    static int[] nextgreater(int[] arr,int n){
        int[] ans=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            int val=arr[i];
            while(st.size()>0 && arr[st.peek()]<val)st.pop();
            if(st.size()==0)ans[i]=n;
            else ans[i]=st.peek();
            st.push(i);
        }
        return ans;
    }
}