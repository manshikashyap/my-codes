class Solution {
    Integer[][][] memo;
    int m, n;
    int[] DIR = new int[]{0, 1, 0, -1, 0};
    int mod = 1000000007;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        this.m = m; this.n = n;
        memo = new Integer[m][n][maxMove+1];
        return helper(maxMove, startRow, startColumn);
    }
    private int helper(int moves, int i, int j){
        if(i<0 || j<0 || i==m || j==n) return 1; //Reached outside
        if(moves == 0) return 0;
        if(memo[i][j][moves] != null) return memo[i][j][moves];
        int paths = 0;
        for(int l=0; l<4; l++){
            paths = (paths + helper(moves-1, i-DIR[l], j-DIR[l+1])) % mod;
        }
        return memo[i][j][moves] = paths;
    }
}