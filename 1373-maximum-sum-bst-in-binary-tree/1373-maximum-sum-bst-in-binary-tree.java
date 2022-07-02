class Pair{
    boolean isBst;
    int sum;
    int maxi;
    int mini;
    int ans;
}
class Solution {
    public int maxSumBST(TreeNode root) {
        Pair p=solve(root);
        return p.ans;
    }
    
    public Pair solve(TreeNode root){
        Pair p=new Pair();
        if(root==null){
            p.isBst=true;
            p.sum=0;
            p.maxi=Integer.MIN_VALUE;
            p.mini=Integer.MAX_VALUE;
            p.ans=0;
            return p;
        }
        
        Pair left=solve(root.left);
        Pair right=solve(root.right);
        
        p.maxi=Math.max(root.val,right.maxi);
        p.mini=Math.min(root.val,left.mini);
        
        if(left.isBst && right.isBst && root.val>left.maxi && root.val<right.mini){
            p.isBst=true;
            p.sum=left.sum+right.sum+root.val;
            p.ans=Math.max(p.sum,Math.max(left.ans,right.ans));
        }else{
            p.isBst=false;
            p.sum=0;
            p.ans=Math.max(left.ans,right.ans);
        }
        return p;
        
    }
}