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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)return null;
        ListNode ans = new ListNode();
        ListNode temp=ans;
        PriorityQueue<ListNode> pq = new PriorityQueue(lists.length,new Comparator<ListNode>(){
            public int compare(ListNode obj1,ListNode obj2){
               if(obj1.val<obj2.val)return -1;
                else if(obj1.val>obj2.val)return 1;
                else return 0;
            }
        });
        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null)
            pq.offer(lists[i]);
        }
        while(pq.size()>0){
            ListNode l=pq.poll();
            temp.next=l;
            if(l.next!=null)pq.add(l.next);
            temp=temp.next;
        }
        return ans.next;
    }
}