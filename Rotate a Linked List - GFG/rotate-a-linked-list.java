// { Driver Code Starts
import java.util.*;
class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
} 

class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            
            int a = sc.nextInt();
            Node head = new Node(a);
            Node tail = head;
            
            for (int i=0; i<n-1; i++)
            {
                a = sc.nextInt();
                tail.next = new Node(a);
                tail = tail.next;
            }
            
            int k = sc.nextInt();
            
            Solution ob = new Solution();
            head = ob.rotate(head,k);
            printList(head);
        }
    }
    
    public static void printList(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }
}
// } Driver Code Ends


/* node of linked list:

class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}

*/

class Solution{
    //Function to rotate a linked list.
    public int size(Node head){
        int size=0;
        Node tmp=head;
        while(tmp!=null){
            tmp=tmp.next;
            size++;
        }
        
        return size;
    }
    public Node rotate(Node head, int k) {
        // add code here
      
        Node fast=head;
        Node tmp=head;
        int s=size(head);
        if(s==k)return head;
        k=k%s;
        while(tmp.next!=null){
            tmp=tmp.next;
        }
        tmp.next=head;
        for(int i=0;i<k-1;i++){
            fast=fast.next;
            
        }
        Node slow=fast.next;
        fast.next=null;
        return slow;
        
    }
}
