/**
 * Created by sheshnath on 5/31/2017.
 * problem Link : https://leetcode.com/problems/rotate-list/#/description
 *
 * Rotate LinkedList right by K
 */
public class RotateList {

    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(k==0 || head==null || head.next == null){
            return head;
        }
        int n = 0;
        ListNode temp = head;
        while(temp!=null){
            n++;
            temp = temp.next;
        }

        if(k>n){
            k = k%n;
        }
        if(n==k || k == 0){
            return head;
        }
        temp = head;
        ListNode prev = null;
        int count = 0;
        while(count<(n-k)){
            prev = temp;
            temp = temp.next;
            count++;
        }
        ListNode newHead= temp;
        if(prev != null)
            prev.next = null;

        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = head;
        return newHead;
    }
}
