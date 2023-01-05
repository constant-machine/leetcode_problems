public class Solution {

  public ListNode oddEvenList(ListNode head) {
    if (head == null) return null;
    if (head.next == null) return head;
    if (head.next.next == null) return head;

    ListNode evenListHead = new ListNode(head.next.val);
    ListNode evenListCurr = evenListHead;
    ListNode curr = head;
    do {
      if (curr.next.next == null) {
        evenListCurr.next = curr.next;
        evenListCurr = evenListCurr.next;
        evenListCurr.next = null;
        break;
      }
      curr.next = curr.next.next;
      curr = curr.next;
      evenListCurr.next = curr.next;
      evenListCurr = evenListCurr.next;
    } while(curr.next != null);
    curr.next = evenListHead;
    return head;
  }
}
