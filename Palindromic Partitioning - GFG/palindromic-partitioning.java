// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int palindromicPartition(String str)
    {
        int n= str.length();
        boolean[][] mark=new boolean[n][n];
        for(int g=0;g<n;g++){
            for(int i=0, j=g;j<n;j++,i++){
                if(g==0){
                    mark[i][j]=true;
                }
                else if(g==1){
                    if(str.charAt(i)==str.charAt(j))mark[i][j]=true;
                }
                else{
                    if(str.charAt(i)==str.charAt(j)){
                        mark[i][j]=mark[i+1][j-1];
                    }
                }
            }
        }
        int[] dp=new int[n];
        dp[0]=0;
        for(int j=1;j<n;j++){
            if(mark[0][j]){
                dp[j]=0;
                continue;
            }
            int min=Integer.MAX_VALUE;
            for(int i=j;i>=1;i--){
                if(mark[i][j] && min>dp[i-1])min=dp[i-1];
            }
            dp[j]=min+1;
        }
        return dp[n-1];
    }
}