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
    // 1 covered
    // 0 has camera
    // -1 needs 
     int cameras=0;
    public int minCameraCover_(TreeNode root){
        if(root==null)return 1;
        int lchild=minCameraCover_(root.left);
        int rchild= minCameraCover_(root.right);
        
        if(rchild== -1|| lchild==-1){
            cameras++;
            return 0;
        }
        if(rchild==0 || lchild==0)return 1;
        else return -1;
    }
    
    public int minCameraCover(TreeNode root) {
        if(minCameraCover_(root)==-1)cameras++;
        return cameras;
    }
}