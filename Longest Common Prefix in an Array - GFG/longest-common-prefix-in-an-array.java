//{ Driver Code Starts
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
            int n = Integer.parseInt(read.readLine().trim());
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    String longestCommonPrefix(String arr[], int n){
        // code here
        Arrays.sort(arr);
        String s1=arr[0];
        String s2=arr[n-1];
        String ans="";
        int i=0;
        while(i<s1.length()&&i<s2.length()){
            if(s1.charAt(i)==s2.charAt(i)){
                ans+=s1.charAt(i);
                i++;
            }else break;
        }
        if(ans.length()==0)ans+=-1;
        return ans;
    }
}