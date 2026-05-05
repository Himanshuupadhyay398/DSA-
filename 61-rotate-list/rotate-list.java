import java.util.*;
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode() {}
//  *     ListNode(int val) { this.val = val; }
//  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  * }
//  */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode temp=head;
        int length=1;
        if(head==null || head.next==null){
            return head;
        }
        while(temp.next!=null){
            temp=temp.next;
            length++;
        }
        k=k%length;
        if(k==0) return head;
        int remain=length-k;
        ListNode temp1=head;
        for(int i=1;i<remain;i++){
            temp1=temp1.next;
        }
        temp.next=head;
        head=temp1.next;
        temp1.next=null;
        return head;
    }
}