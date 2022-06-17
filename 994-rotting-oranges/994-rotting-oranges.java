class Solution {
    public int orangesRotting(int[][] grid) {
        int r=grid.length;
        int c=grid[0].length;
        Queue<int[]> q= new LinkedList<>();
        int icnt=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }
                if(grid[i][j] !=0)icnt++;
            }
        }
        if(icnt==0)return 0;
        int min=0;
        int cnt=0;
        int[] dx={0,0,1,-1};
        int[] dy={1,-1,0,0};
         //bfs
        while(q.size()>0){
            int size=q.size();
            cnt+=size;
            for(int k=0;k<size;k++){
                int[] temp=q.poll();
                for(int i=0;i<4;i++){
                    int x=temp[0]+dx[i];
                    int y=temp[1]+dy[i];
                    if(x<0||y<0||x>=r||y>=c||grid[x][y]==0||grid[x][y]==2)continue;
                    grid[x][y]=2;
                    q.offer(new int[]{x,y});
                }
            }
            if(q.size()>0)min++;
        }
        return cnt==icnt?min:-1;
    }
}