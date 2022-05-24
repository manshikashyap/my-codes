// { Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(first, second);
            printList(res);
        }
    }
}
// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    //Function to add two numbers represented by linked list.
    static Node reverseList(Node head)
    {
        // code here
        Node temp=null;
        Node tmp=head;
        while(tmp!=null){
            Node t=tmp.next;
            tmp.next=temp;
            temp=tmp;
            tmp=t;
        }
        head =temp;
        return temp;
    }
    
    static Node addTwoLists(Node first, Node second){
        // code here
        // return head of sum list
        Node n1=reverseList(first);
        Node n2=reverseList(second);
        Node dummy=new Node(0);
        Node temp=dummy;
        int c=0;
        while(n1!=null||n2!=null||c!=0){
            int sum=0;
            if(n1!=null){
                sum+=n1.data;
                n1=n1.next;
                
            }
            if(n2!=null){
                sum+=n2.data;
                n2=n2.next;
            }
            sum+=c;
            c=sum/10;
            Node ans=new Node(sum%10);
            temp.next=ans;
            temp=temp.next;
            
        }
        Node n=reverseList(dummy.next);
        return n;
        
    }
}