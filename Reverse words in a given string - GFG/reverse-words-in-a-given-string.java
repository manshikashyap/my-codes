//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}

// } Driver Code Ends



class Solution 
{
    //Function to reverse words in a given string.
    String reverseWords(String s)
    {
        // code here 
        String ans="";
        int i=0;
        int n=s.length();
        String temp[]=s.split("[.]");

        int l=0;
        int h=temp.length-1;
        while(l<h){
           String str=temp[l];
           temp[l]=temp[h];
           temp[h]=str;
           l++;
           h--;
        }
        for(i=0;i<temp.length;i++){
            if(i==temp.length-1){
                ans+=temp[i];
            }
            else{
                ans+=temp[i];
                ans+='.';
            }
        }
        return ans;
    }
}