// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
public class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n;
                    n = sc.nextInt();
                    ArrayList<String> arr = new ArrayList<String>();
                    for(int i = 0;i<n;i++)
                        {
                            String p = sc.next();
                            arr.add(p);
                        }
                    String line = sc.next();
                    Sol obj = new Sol();  
                    System.out.println(obj.wordBreak(line,arr));  
                    
                }
        }
}// } Driver Code Ends


//User function Template for Java

class Sol
{
    public static int wordBreak(String a, ArrayList<String> b )
    {
       boolean[] dp=new boolean[a.length()+1];
       dp[0]=true;
       for(int i=1;i<dp.length;i++){
           for(int j=0;j<i;j++){
               if(dp[j] && b.contains(a.substring(j,i))){
                   dp[i]=true;
                   break;
               }
           }
       }
       return dp[a.length()]==true?1:0;
    }

}