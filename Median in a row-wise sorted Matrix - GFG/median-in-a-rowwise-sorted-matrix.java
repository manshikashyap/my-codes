// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S[] = read.readLine().split(" ");
            int R = Integer.parseInt(S[0]);
            int C = Integer.parseInt(S[1]);
            String line[] = read.readLine().trim().split("\\s+");
            int matrix[][] = new int[R][C];
            int c = 0;
            for(int i = 0; i < R; i++){
                for(int j = 0; j < C; j++){
                    matrix[i][j] = Integer.parseInt(line[c++]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.median(matrix, R, C);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int median(int arr[][], int r, int c) {
        int l=0;
        int h=1000000000;
        while(l<=h){
            int mid=(l+h)/2;
            int count=0;
            for(int i=0;i<r;i++){
                count+=binarysearch(arr[i],0,c-1,mid);
            }
            if(count<=(r*c)/2)l=mid+1;
            else h=mid-1;
        }
        return l;
    }
    int binarysearch(int[] arr,int l,int h,int val){
        while(l<=h){
            int mid=(l+h)/2;
            if(arr[mid]<=val)l=mid+1;
            else h=mid-1;
        }
        return l;
    }
}