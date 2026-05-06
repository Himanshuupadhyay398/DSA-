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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode temp=list1;
        for(int i=1;i<a;i++){
            temp=temp.next;
        }
        ListNode fh=temp;
        temp=list1;
        for(int i=1;i<=b;i++){
            temp=temp.next;
        }
        ListNode sh=temp.next;
        ListNode temp1=list2;
        while(temp1.next!=null){
            temp1=temp1.next;
        }
        temp1.next=sh;
        fh.next=list2;
        return list1;
    }
}