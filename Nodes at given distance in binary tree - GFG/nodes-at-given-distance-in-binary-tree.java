//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException
    {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine().trim();
            Node root = buildTree(s);
            Solution T = new Solution();
            int target = Integer.parseInt(br.readLine().trim());
            int k = Integer.parseInt(br.readLine().trim());
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = T.KDistanceNodes(root,target,k);
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();    
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right;
// }



class Solution
{
    public static void markParents(Node root,Map<Node,Node> parent_track,Node target){
        Queue<Node> q=new LinkedList<>();
        q.offer(root);
        while(q.size()>0){
            Node curr=q.poll();
            if(curr.left!=null){
                parent_track.put(curr.left,curr);
                q.offer(curr.left);
            }
             if(curr.right!=null){
                parent_track.put(curr.right,curr);
                q.offer(curr.right);
            }
        }
    }
    
    public static Node helper(Node root,int target){
        Queue<Node> q=new LinkedList<>();
        q.offer(root);
        while(q.size()>0){
            Node curr=q.poll();
            if(curr.data==target)return curr;
            if(curr.left!=null){
                q.offer(curr.left);
            }
             if(curr.right!=null){
                q.offer(curr.right);
            }
        }
        return null;
    }
    
    public static ArrayList<Integer> KDistanceNodes(Node root, int target , int k)
    {
        // return the sorted list of all nodes at k dist
        ArrayList<Integer> ans= new ArrayList<>();
        if(root==null)return ans;
        Node tar=helper(root,target);
        Map<Node,Node> parent_track=new HashMap<>();
        markParents(root,parent_track,tar);
        Map<Node,Boolean> visited= new HashMap<>();
        Queue<Node> q= new LinkedList<>();
        q.offer(tar);
        visited.put(tar,true);
        int curr_level=0;
        while(!q.isEmpty()){
            int size=q.size();
            if(curr_level==k)break;
            curr_level++;
            for(int i=0;i<size;i++){
                Node curr=q.poll();
                if(curr.left!=null && visited.get(curr.left)==null){
                    q.offer(curr.left);
                    visited.put(curr.left,true);
                }
                if(curr.right!=null && visited.get(curr.right)==null){
                    q.offer(curr.right);
                    visited.put(curr.right,true);
                }
                if(parent_track.get(curr)!=null && visited.get(parent_track.get(curr))==null){
                    q.offer(parent_track.get(curr));
                    visited.put(parent_track.get(curr),true);
                }
            }
        }
        while(!q.isEmpty()){
            Node curr=q.poll();
            ans.add(curr.data);
        }
        Collections.sort(ans);
        return ans;
    }
};