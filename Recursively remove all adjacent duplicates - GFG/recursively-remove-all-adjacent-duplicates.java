//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            String S = br.readLine();
            Solution ob = new Solution();
            System.out.println(ob.rremove(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    
    String rremove(String s) {
        // code here
        int n=s.length();
        String s1="";
        while(s1.length()!=s.length()){
            s1=s;
            s=remove(s);
        }
        return s;
    }
    String remove(String str){
        StringBuilder res=new StringBuilder();
        int i=0;
        int n=str.length();
        while(i<n){
            if(i<n-1 && str.charAt(i)==str.charAt(i+1)){
                while(i<n-1 && str.charAt(i)==str.charAt(i+1))i++;
            }
            else res.append(str.charAt(i));
            i++;
        }
        return res.toString();
    }
}    