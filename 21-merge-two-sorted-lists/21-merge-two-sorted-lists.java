/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode a= new ListNode(0);
        ListNode ans=a;
        ListNode n1 =list1;
        ListNode n2=list2;
        while(n1!=null&&n2!=null){
            if(n1.val<=n2.val){
                ans.next=n1;
                n1=n1.next;
                ans=ans.next;
            }
            else{
                ans.next=n2;
                n2=n2.next;
                ans=ans.next;
            }
        }
        while(n1!=null){
            ans.next=n1;
                n1=n1.next;
                ans=ans.next;
        }
        while(n2!=null){
            ans.next=n2;
                n2=n2.next;
                ans=ans.next;
        }
        return a.next;
    }
}