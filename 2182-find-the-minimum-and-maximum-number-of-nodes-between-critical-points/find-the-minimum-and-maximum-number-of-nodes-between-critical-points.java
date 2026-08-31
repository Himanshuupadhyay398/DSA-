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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev=head;
        ListNode temp=head.next;
        ListNode nex=head.next.next;
        if(nex==null) return new int[]{-1,-1};

        int prevNode=0,mindist=Integer.MAX_VALUE;
        int index=1;
        int firstNode=0;
        while(temp.next!=null){
            if((prev.val<temp.val && temp.val>nex.val)  || (prev.val>temp.val && temp.val<nex.val)){
                if(firstNode==0) firstNode=index;
                else mindist=Math.min(mindist,index-prevNode);
                prevNode=index;
            }
            prev=temp;
            temp=nex;
            nex=nex.next;
            index++;
        }
        if(firstNode==prevNode) return new int[]{-1,-1};
    return new int[]{mindist,prevNode-firstNode};
    }
}