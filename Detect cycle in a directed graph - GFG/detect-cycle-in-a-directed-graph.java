//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int v, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int[] visited=new int[v];
        int[] dvisited=new int[v];
        for(int i=0;i<v;i++){
            if(visited[i]==0){
                if(helper(i,adj,visited,dvisited)==true)return true;
            }
        }
        return false;
    }
    public boolean helper(int i, ArrayList<ArrayList<Integer>> adj, int[] visited, int[] dvisited){
        visited[i]=1;
        dvisited[i]=1;
        for(int val:adj.get(i)){
            if(visited[val]==0){
                if(helper(val,adj,visited,dvisited)==true)return true;;
            }else if(dvisited[val]==1)return true;
        }
        dvisited[i]=0;
        return false;
    }
}