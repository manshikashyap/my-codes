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
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestSubstrDistinctChars(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int longestSubstrDistinctChars(String S){
        // code here
        int ans=0;
        HashMap<Character,Integer> hm = new HashMap<>();
        int n=S.length();
        int i=0;
        int l=0;
        while(i<n){
            if(hm.containsKey(S.charAt(i))){
                l=Math.max(l,hm.get(S.charAt(i))+1);
            }
            hm.put((S.charAt(i)),i);
            ans=Math.max(ans,i-l+1);
            i++;
        }
       
        return ans;
        
    }
}