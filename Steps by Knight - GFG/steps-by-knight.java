//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            String[] S1 = br.readLine().trim().split(" ");
            String[] S2 = br.readLine().trim().split(" ");
            int[] KnightPos = new int[2];
            int[] TargetPos = new int[2];
            for(int i = 0; i < 2; i++){
                KnightPos[i] = Integer.parseInt(S1[i]);
                TargetPos[i] = Integer.parseInt(S2[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minStepToReachTarget(KnightPos, TargetPos, N);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends


class Solution
{
    //Function to find out minimum steps Knight needs to reach target position.
    class pair{
        int s;
        int e;
        pair(int s,int e){
            this.s=s;
            this.e=e;
        }
    }
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int n)
    {
        int[][] arr=new int[n][n];
        for (int[] row: arr)
            Arrays.fill(row, Integer.MAX_VALUE);

        int i1=KnightPos[0]-1;
        int j1=KnightPos[1]-1;
        int i2=TargetPos[0]-1;
        int j2=TargetPos[1]-1;
        arr[i1][j1]=0;
        if(i1==i2 && j1==j2)return 0;
        Queue<pair> q= new LinkedList<>();
        q.add(new pair(i1,j1));
        while(q.size()>0){
            pair p=q.poll();
            int i=p.s;
            int j=p.e;
            if(i+1>=0 && i+1<n && j+2>=0 && j+2<n && arr[i+1][j+2]>arr[i][j]+1){
                arr[i+1][j+2]=arr[i][j]+1;
                q.add(new pair(i+1,j+2));
            }
            if(i-1>=0 && i-1<n && j+2>=0 && j+2<n && arr[i-1][j+2]>arr[i][j]+1){
                arr[i-1][j+2]=arr[i][j]+1;
                q.add(new pair(i-1,j+2));
            }
            if(i+1>=0 && i+1<n && j-2>=0 && j-2<n && arr[i+1][j-2]>arr[i][j]+1){
                arr[i+1][j-2]=arr[i][j]+1;
                q.add(new pair(i+1,j-2));
            }
            if(i-1>=0 && i-1<n && j-2>=0 && j-2<n && arr[i-1][j-2]>arr[i][j]+1){
                arr[i-1][j-2]=arr[i][j]+1;
                q.add(new pair(i-1,j-2));
            }
            if(i+2>=0 && i+2<n && j-1>=0 && j-1<n && arr[i+2][j-1]>arr[i][j]+1){
                arr[i+2][j-1]=arr[i][j]+1;
                q.add(new pair(i+2,j-1));
            }
            if(i+2>=0 && i+2<n && j+1>=0 && j+1<n && arr[i+2][j+1]>arr[i][j]+1){
                arr[i+2][j+1]=arr[i][j]+1;
                q.add(new pair(i+2,j+1));
            }
            if(i-2>=0 && i-2<n && j+1>=0 && j+1<n && arr[i-2][j+1]>arr[i][j]+1){
                arr[i-2][j+1]=arr[i][j]+1;
                q.add(new pair(i-2,j+1));
            }
            if(i-2>=0 && i-2<n && j-1>=0 && j-1<n && arr[i-2][j-1]>arr[i][j]+1){
                arr[i-2][j-1]=arr[i][j]+1;
                q.add(new pair(i-2,j-1));
            }
        }
        return arr[i2][j2];
    }
    
}