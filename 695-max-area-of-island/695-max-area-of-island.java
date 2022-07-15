class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ans=0;
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] visited= new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    int area= dfs(grid,i,j,visited);
                    ans=Math.max(ans,area);
                }
            }
        }
        return ans;
    }
    public int dfs(int[][] grid,int i,int j,boolean[][] visited){
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]==0||visited[i][j])return 0;
        visited[i][j]=true;
        int curr=1;
        curr+=dfs(grid,i+1,j,visited);
        curr+=dfs(grid,i-1,j,visited);
        curr+=dfs(grid,i,j+1,visited);
        curr+=dfs(grid,i,j-1,visited);
        return curr;
    }
}