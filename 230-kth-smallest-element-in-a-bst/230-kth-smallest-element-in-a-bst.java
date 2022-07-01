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
    public int kthSmallest(TreeNode root, int k) {
        int c=0;
        int ans=0;
        TreeNode curr=root;
        while(curr!=null){
            if(c==k)break;
            TreeNode ln=curr.left;
            if(ln==null){
                c++;
                ans=curr.val;
                curr=curr.right;
            }
            else{
                while(ln.right!=null && ln.right!=curr){
                    ln=ln.right;
                }
                if(ln.right==null){
                    ln.right=curr;
                    curr=curr.left;
                }
                else{
                    c++;
                    ans=curr.val;
                    ln.right=null;
                    curr=curr.right;
                }
            }
        }
        return ans;
    }
}