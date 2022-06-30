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
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayBST(nums,0,nums.length-1);
    }
    public TreeNode sortedArrayBST(int[] nums,int l, int h){
        if(l>h)return null;
        int mid=(l+h)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=sortedArrayBST(nums,l,mid-1);
        root.right=sortedArrayBST(nums,mid+1,h);
        return root;
    }
}