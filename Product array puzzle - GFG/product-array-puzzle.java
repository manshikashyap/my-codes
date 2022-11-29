//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
        	int n = sc.nextInt();
        	int[] array = new int[n];
        	for (int i=0; i<n ; i++ ) {
        		array[i] = sc.nextInt();
        	}
            Solution ob = new Solution();
            long[] ans = new long[n];
            ans = ob.productExceptSelf(array, n); 

           	for (int i = 0; i < n; i++) { 
				System.out.print(ans[i]+" ");
			} 
            System.out.println();
            t--;
        }
    } 
} 
  


// } Driver Code Ends


//User function Template for Java


class Solution 
{ 
	public static long[] productExceptSelf(int nums[], int n) 
	{   
        long[] ans=new long[n];
        if(n==1){
            ans[0]=1;
            return ans;
        }
        long[] p=new long[n];
        long[] p1=new long[n];
        p[0]=nums[0];
        p1[n-1]=nums[n-1];
        for(int i=1;i<n;i++){
            p[i]=p[i-1]*nums[i];
        }
        for(int i=n-2;i>=0;i--){
            p1[i]=p1[i+1]*nums[i];
        }
        ans[0]=p1[1];
        ans[n-1]=p[n-2];
        for(int i=1;i<n-1;i++){
            ans[i]=p[i-1]*p1[i+1];
        }
        return ans;
	} 
} 
