//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Rearr
{
    static Node head;
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t  =sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node temp = head;
            for(int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                temp.next = new Node(a);
                temp = temp.next;
            }
            
            Solution ob = new Solution();
            ob.rearrange(head);
            printLast(head);
            System.out.println();
        }
    }
    
    public static void printLast(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
// } Driver Code Ends


/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}*/
class Solution
{
    public static void rearrange(Node odd)
    {
        // add your code here
        if(odd==null)return;
        int i=1;
        int cnt=1;
        Node temp=odd;
        Node prev=null;
        while(odd.next!=null){
            odd=odd.next;
            cnt++;
        }
        while(temp!=null && i<cnt){
            if(i%2==0){
                prev.next=temp.next;
                Node n=odd.next;
                odd.next=new Node(temp.data);
                odd.next.next=n;
                temp=temp.next;
                i++;
            }
            else{
                i++;
                prev=temp;
                temp=temp.next;
            }
            
        }
      
    }
}
