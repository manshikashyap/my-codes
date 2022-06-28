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
    int pidx=0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        pidx=postorder.length-1;
        TreeNode root=construct(inorder,postorder,0,inorder.length-1);
        return root;
    }
    public TreeNode construct(int[] inorder, int[] postorder,int s,int e){
        if(s>e)return null;
        TreeNode root=new TreeNode(postorder[pidx--]);
        int idx=-1;
        for(int i=s;i<=e;i++){
            if(inorder[i]==root.val){
                idx=i;
                break;
            }
        }
        root.right=construct(inorder,postorder,idx+1,e);
        root.left=construct(inorder,postorder,s,idx-1);
        return root;
    }
}