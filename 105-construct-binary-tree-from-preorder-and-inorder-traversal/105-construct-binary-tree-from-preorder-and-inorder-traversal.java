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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = construct(preorder,inorder,0,inorder.length-1);
        return root;
    }
    public TreeNode construct(int[] preorder, int[] inorder,int s,int e){
        if(s>e)return null;
        TreeNode root = new TreeNode(preorder[pidx++]);
        int idx=-1;
        for(int i=s;i<=e;i++){
            if(inorder[i]==root.val){
                idx=i;
                break;
            }
        }
        root.left=construct(preorder,inorder,s,idx-1);
        root.right=construct(preorder,inorder,idx+1,e);
        return root;
    }
}