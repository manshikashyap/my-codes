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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        if(root==null)return ans;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(q.size()>0){
            ans.add(q.peek().val);
            int size=q.size();
            TreeNode temp=null;
            while(size>0){
                temp=q.poll();
                if(temp.right!=null)q.offer(temp.right);
                if(temp.left!=null)q.offer(temp.left);
                size--;
            }
        }
        return ans;
    }
}