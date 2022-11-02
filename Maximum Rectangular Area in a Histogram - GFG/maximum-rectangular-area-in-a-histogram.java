//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new Solution().getMaxArea(arr, n));
		}
	}
}




// } Driver Code Ends


class Solution
{
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long hist[], long n) 
    {
        long[] gr=new long[hist.length];
        long gl[]=new long[hist.length];
        ngr(gr,hist);
        ngl(gl,hist);
        long ans=0;
        for(int i=0;i<n;i++){
            ans=Math.max(ans,Math.abs(gr[i]-gl[i]-1)*hist[i]);
        }
        return ans;
    }
    public static void ngr(long gr[],long arr[]){
        Stack<Integer> st=new Stack<>();
        gr[arr.length-1]=arr.length;
        st.push(arr.length-1);
        for(int i=arr.length-2;i>=0;i--){
            while(st.size()>0 && arr[st.peek()]>=arr[i])st.pop();
            if(st.size()>0)gr[i]=st.peek();
            else{
                gr[i]=arr.length;
            }
            st.push(i);
        }
    }
    public static void ngl(long gl[],long arr[]){
        Stack<Integer> st=new Stack<>();
        gl[0]=-1;
        st.push(0);
        for(int i=1;i<arr.length;i++){
            while(st.size()>0 && arr[st.peek()]>=arr[i])st.pop();
            if(st.size()>0)gl[i]=st.peek();
            else{
                gl[i]=-1;
            }
            st.push(i);
        }
    }
        
}



