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
    TreeNode node=new TreeNode();
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null){
            node=null;
            return null;
        }
        if(root.val==val){
            node=root;
            return root;
        }
        else if(root.val>val)searchBST(root.left,val);
        else if(root.val<val)searchBST(root.right,val);
        return node;
    }
}