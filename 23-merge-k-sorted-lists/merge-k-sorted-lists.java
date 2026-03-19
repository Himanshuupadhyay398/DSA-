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
        int k=lists.length;
        ArrayList<Integer> lst=new ArrayList<>();
        for(ListNode node:lists){
            while(node!=null){
                lst.add(node.val);
                node=node.next;
            }
        }

        Collections.sort(lst);
        ListNode dummy=new ListNode(0);
        ListNode temp=dummy;
        for(int val:lst){
            temp.next=new ListNode(val);
            temp=temp.next;
        }
    return dummy.next;
    }
}