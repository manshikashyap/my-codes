/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    
    public Node cloneGraph(Node node) {
       if(node==null)return null;
        Node[] visited=new Node[101];
        Node root=new Node(node.val);
        visited[node.val]=root;
        for(Node n:node.neighbors){
            if(visited[n.val]==null){
                Node temp=new Node(n.val);
                root.neighbors.add(temp);
                dfs(n,temp,visited);
            }
            else{
                root.neighbors.add(visited[n.val]);
            }
        }
        return root;
    }
    public void dfs(Node n,Node temp,Node[] visited){
        visited[n.val]=temp;
        for(Node cur : n.neighbors){
             if(visited[cur.val]==null){
                Node tmp=new Node(cur.val);
                temp.neighbors.add(tmp);
                dfs(cur,tmp,visited);
            }
            else{
                temp.neighbors.add(visited[cur.val]);
            }
        }
    }
}