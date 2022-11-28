//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-- > 0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] a = new int[n];
            String[] inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Compute obj = new Compute();
            System.out.println(obj.findElement(a, n));
            
        }
	}
}
// } Driver Code Ends


//User function Template for Java

class Compute {
    public int findElement(int arr[], int n){
        int[] lmax=new int[n];
        int[] rmin=new int[n];
        lmax[0]=arr[0];
        rmin[n-1]=arr[n-1];
        for(int i=1;i<n;i++){
            lmax[i]=Math.max(arr[i],lmax[i-1]);
        }
        for(int i=n-2;i>=0;i--){
            rmin[i]=Math.min(arr[i],rmin[i+1]);
        }
        for(int i=1;i<n-1;i++){
            if(arr[i]>=lmax[i] && arr[i]<=rmin[i])return arr[i];
        }
        
        return -1;
    }
}