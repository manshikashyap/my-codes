class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(color==image[sr][sc])return image;
        int r=image.length;
        int c=image[0].length;
        int src=image[sr][sc];
        dfs(image,sr,sc,color,r,c,src);
        return image;
    }
    public void dfs(int[][] image, int sr, int sc, int color,int r,int c,int src){
        if(sr<0||sr>=r||sc<0||sc>=c||image[sr][sc]!=src)return;
        image[sr][sc]=color;
        dfs(image,sr-1,sc,color,r,c,src);
        dfs(image,sr,sc+1,color,r,c,src);
        dfs(image,sr+1,sc,color,r,c,src);
        dfs(image,sr,sc-1,color,r,c,src);
    }
}