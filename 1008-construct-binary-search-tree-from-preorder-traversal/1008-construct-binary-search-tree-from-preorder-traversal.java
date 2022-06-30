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
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root=new TreeNode (preorder[0]);
        for(int i=1;i<preorder.length;i++){
            helper(root,preorder[i]);
        }
        return root;
    }
    public TreeNode helper(TreeNode root,int val){
        TreeNode node=new TreeNode (val);
   
        if(val<root.val ){
            if(root.left==null)
                root.left=node;
            else helper(root.left,val);
        }
        if(val>root.val){
            if(root.right==null)
                root.right=node;
            else helper(root.right,val);
        }
        return root;
    }
}