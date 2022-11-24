//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to find the number of islands.
    
    public int numIslands(char[][] grid) {
        // Code here
        int ans=0;
        int n= grid.length;
        int m=grid[0].length;
        boolean visited[][]=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && grid[i][j]=='1'){
                    helper(grid,visited,i,j,n,m);
                    ans++;
                }
            }
        }
        return ans;
    }
    public void helper(char[][] grid,boolean visited[][],int i,int j,int n,int m){
        if(i<0 || j<0 || i>=n || j>=m || visited[i][j] || grid[i][j]=='0')return;
        visited[i][j]=true;
        helper(grid,visited,i,j+1,n,m);
        helper(grid,visited,i,j-1,n,m);
        helper(grid,visited,i+1,j,n,m);
        helper(grid,visited,i-1,j,n,m);
        helper(grid,visited,i+1,j+1,n,m);
        helper(grid,visited,i+1,j-1,n,m);
        helper(grid,visited,i-1,j+1,n,m);
        helper(grid,visited,i-1,j-1,n,m);
        
        
    }
}