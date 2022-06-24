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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans= new ArrayList<>();
        if(root==null)return ans;
        int l=0;
        Queue<TreeNode> q= new LinkedList<>();
        q.offer(root);
        while(q.size()>0){
            List<Integer> list= new ArrayList<>();
            int size=q.size();
            while(size>0){
                TreeNode node =q.poll();
                list.add(node.val);
                if(node.left!=null){
                    q.offer(node.left);
                }
                if(node.right!=null){
                    q.offer(node.right);
                }
                size--;
            }
            if(l%2!=0){
                Collections.reverse(list);
            }
            ans.add(list);
            l++;
        }
        return ans;
    }
}