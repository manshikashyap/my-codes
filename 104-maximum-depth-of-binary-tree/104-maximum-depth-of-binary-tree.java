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
class Solution {
    public int maxDepth(TreeNode root) {
        int h=0;
        Queue<TreeNode> q= new LinkedList<>();
        if(root==null)return h;
        q.offer(root);
        while(q.size()>0){
            int size=q.size();
            h++;
            while(size>0){
                TreeNode n=q.poll();
                if(n.left!=null)
                        q.offer(n.left);
                if(n.right!=null)
                        q.offer(n.right);
                size--;
            }
        }
        return h;
    }
}