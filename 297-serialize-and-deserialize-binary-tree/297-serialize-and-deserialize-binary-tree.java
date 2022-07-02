/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
           return "";
        }
        StringBuilder s= new StringBuilder();
        Queue<TreeNode> q= new LinkedList();
        q.offer(root);
        while(q.size()>0){
            TreeNode node=q.poll();
            if(node==null){
                s.append("# ");
                continue;
            }
            s.append(node.val+" ");
            q.offer(node.left);    
            q.offer(node.right);    
        }
        return s.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data=="")return null;
        Queue<TreeNode> q= new LinkedList<>();
        String[] str=data.split(" ");
        TreeNode root=new TreeNode(Integer.parseInt(str[0]));
        q.offer(root);
        for(int i=1;i<str.length;i++){
            TreeNode temp=q.poll();
            if(!str[i].equals("#")){
                TreeNode left=new TreeNode(Integer.parseInt(str[i]));
                temp.left=left;
                q.add(left);
            }
            if(!str[++i].equals("#")){
                TreeNode right=new TreeNode(Integer.parseInt(str[i]));
                temp.right=right;
                q.add(right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));