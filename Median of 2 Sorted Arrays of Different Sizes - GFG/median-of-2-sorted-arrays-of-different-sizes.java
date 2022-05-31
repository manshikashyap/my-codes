// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Driver
{
    public static void main(String args[]) 
	{ 
	    Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int []a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            
            int  m= sc.nextInt();
            int []b = new int[m];
            for (int i = 0; i < m; i++) b[i] = sc.nextInt();
            
            double res = new GFG().medianOfArrays(n, m, a, b);
            
            if (res == (int)res) System.out.println ((int)res);
            else System.out.println (res);
        }
    		
	} 
}// } Driver Code Ends


//User function Template for Java

class GFG 
{ 
    static double medianOfArrays(int n, int m, int a[], int b[]) 
    {
        // Your Code Here
        if(n>m)return medianOfArrays(m,n,b,a);
        int l=0;
        int h=n;
        while(l<=h){
            int cut1=(l+h)/2;
            int cut2=((n+m+1)/2)-cut1;
            
            int l1=(cut1==0)?Integer.MIN_VALUE:a[cut1-1];
            int l2=(cut2==0)?Integer.MIN_VALUE:b[cut2-1];
            int r1=(cut1==n)?Integer.MAX_VALUE:a[cut1];
            int r2=(cut2==m)?Integer.MAX_VALUE:b[cut2];
            if(l1<=r2 && l2<=r1){
                if((n+m)%2!=0){
                    return Math.max(l1,l2);
                }
                else{
                    return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
                }
            }
            else if(l1>r2){
                h=cut1-1;
            }
            else if(l2>r1){
                l=cut1+1;
            }
        }
        return 0.0;
    }
}