class Solution {
    public boolean canFinish(int n, int[][] graph) {
       boolean[] visited= new boolean[n];
        HashMap<Integer,ArrayList<Integer>> hm=new HashMap<>();
        for(int i=0;i<n;i++)hm.put(i,new ArrayList<Integer>());
        for(int i=0;i<graph.length;i++){
            int val=graph[i][0];
            ArrayList<Integer> list=hm.get(val);
            list.add(graph[i][1]);
            hm.put(val,list);
        }
        for(int i=0;i<n;i++){
            if(visited[i])return false;
            if(!dfs(i,hm,visited))return false;
        }
        return true;
    }
    public boolean dfs(int i, HashMap<Integer,ArrayList<Integer>> hm,boolean[] visited){
        if(visited[i])return false;
        if(hm.get(i)==null)return true;
        visited[i]=true;
        ArrayList<Integer> list=hm.get(i);
        for(int val:list){
            if(!dfs(val,hm,visited))return false;
            
        }
        hm.put(i,new ArrayList<Integer>());
        visited[i]=false;
        return true;
    }
}