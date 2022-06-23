/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Node{
    TreeNode node;
    int v;
    int l;
    Node(TreeNode t,int _v,int _l){
        node=t;
        v=_v;
        l=_l;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Node> q= new LinkedList<>();
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> hm = new TreeMap<>();
        q.offer(new Node(root,0,0));
        int min=0;
        int max=0;
        while(q.size()>0){
            int size=q.size();
            while(size>0){
                Node n=q.poll();
                int v=n.v;
                int h=n.l;
                min=Math.min(min,v);
                max=Math.max(max,v);
                TreeMap<Integer,PriorityQueue<Integer>> list=hm.getOrDefault(v,new TreeMap<Integer,PriorityQueue<Integer>>());
                PriorityQueue<Integer> pq=list.getOrDefault(h, new PriorityQueue<Integer>());
                pq.add(n.node.val);
                list.put(h,pq);
                hm.put(v,list);
                if(n.node.left != null)
                    q.add(new Node(n.node.left,v-1,h+1));
                if(n.node.right != null)
                    q.add(new Node(n.node.right,v+1,h+1));
                size--;
            }
        }
        List<List<Integer>> ans= new ArrayList<>();
       for (Integer hd: hm.keySet()) {
            TreeMap<Integer, PriorityQueue<Integer>> temp = hm.get(hd);
            List<Integer> l = new ArrayList<>();
            for (Integer row: temp.keySet()) {
                PriorityQueue<Integer> pq = temp.get(row);
                while (!pq.isEmpty()) {
                    l.add(pq.poll());
                }
            }
            ans.add(l);
        }
        return ans;
    }
}