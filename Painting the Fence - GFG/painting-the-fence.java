// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


 // } Driver Code Ends
//User function Template for Java


class Solution
{   long mod=(long)1e9+7;
    long countWays(int n,int k)
    {   if(n==1)return k%mod;
        int i=2;
        long same=k;
        long diff=k*(k-1);
        long total=same+diff;
        i++;
        while(i<=n){
            same=diff;
            diff=(total*(k-1))%mod;
            total=(same+diff)%mod;
            i++;
        }
        return total%mod;
    }
}




// { Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main (String[] args) throws IOException{
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while(testcases-- > 0){
            //int n=Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] a2 = line.trim().split("\\s+");
            int n =Integer.parseInt(a2[0]);
            int k =Integer.parseInt(a2[1]);

            Solution ob=new Solution();
            //ArrayList<Long> ans=ob.smallestDifferenceTriplet(a,b,c,n);
            long ans=ob.countWays(n,k);
            System.out.println(ans);
        }
    }
}


  // } Driver Code Ends