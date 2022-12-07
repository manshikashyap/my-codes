//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int isSubsetSum(int n,int set[], int sum){
       boolean qb[][] = new boolean[n+1][sum+1];
       qb[0][0]=true;
       for(int i =1;i<=n;i++){
           for(int j =0;j<=sum;j++){
               if(j==0){
                   qb[i][j]=true;
                   continue;
               }
               boolean can = false;
               if(i>0){
                   can = qb[i-1][j];
               }
               if(can == false && j>=set[i-1] && i>0){
                   int req = j - set[i-1];
                   can = qb[i-1][req];
               }
               qb[i][j]=can;
           }
       }
       if(qb[n][sum])return 1;
       else return 0;
    }

    static int equalPartition(int n, int arr[])
    {
        // code here
        int sum=0;
        for(int val:arr)sum+=val;
        if(sum%2!=0)return 0;
        return isSubsetSum(n,arr,sum/2);
    }
}