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
class pair{
    TreeNode node;
    int l;
    pair(TreeNode n,int x){
        node=n;
        l=x;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null)return 0;
        Queue<pair>q=new LinkedList<>();
        int ans=0;
        q.add(new pair(root,0));
        while(q.size()>0){
            int size=q.size();
            int min=Integer.MAX_VALUE;
            int max=Integer.MIN_VALUE;
            while(size>0){
                pair p=q.poll();
                int v=p.l;
                min=Math.min(min,v);
                max=Math.max(max,v);
                if(p.node.left!=null)
                    q.add(new pair(p.node.left,2*v+1));
                if(p.node.right!=null)
                    q.add(new pair(p.node.right,2*v+2));
                
                size--;
            }
            ans=Math.max(ans,max-min+1);
        }
        return ans;
    }
}