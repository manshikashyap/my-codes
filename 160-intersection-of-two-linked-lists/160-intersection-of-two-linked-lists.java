/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 =headA;
        ListNode l2 = headB;
        int s1=0;
        int s2 =0;
        while(l1!=null){
            l1=l1.next;
            s1++;
        }
        while(l2!=null){
            l2=l2.next;
            s2++;
        }
        ListNode t1 =headA;
        ListNode t2 = headB;
        int diff=Math.abs(s1-s2);
        if(s1<s2){
            for(int i=0;i<diff;i++){
                t2=t2.next;
            }
        }
        else if(s1>s2){
            for(int i=0;i<diff;i++){
                t1=t1.next;
            }
        }
        while(t1 != t2){
            t1=t1.next;
            t2=t2.next;
            
        }
        return t1;
    }
}