class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] arr=new int[n];
        Arrays.fill(arr,-1);
        Queue<Integer> q= new LinkedList<>();
        boolean visited[]=new boolean[n];
        for(int i=0;i<n;i++){
            if(visited[i])continue;
            q.offer(i);
            arr[i]=0;
            while(q.size()>0){
            int val=q.poll();
            visited[val]=true;    
            for(int num:graph[val]){
                if(arr[num]==-1){
                    if(arr[val]==0)arr[num]=1;
                    else arr[num]=0;
                }
                else{
                    if(arr[num]==arr[val])return false;
                    continue;
                }
                q.offer(num);
            }
        }
        }
        return true;
    }
}