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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        recursion(dummy);
        return dummy.next;

        // while(current.next != null && current.next.next != null){

        //     ListNode first = current.next;
        //     ListNode second = current.next.next;

        //     first.next = second.next;
        //     second.next = first;
        //     current.next = second;

        //     current = first;
        // }
        // return dummy.next;
    }
    public ListNode recursion(ListNode curr){
        if(curr.next == null || curr.next.next == null) {
            return curr.next;
        }

        ListNode fir = curr.next;
        ListNode second = curr.next.next;

        fir.next = second.next;
        second.next = fir; 
        curr.next = second;

        return recursion(fir);
    }
}