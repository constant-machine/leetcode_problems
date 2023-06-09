public class Solution {

    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return null;
        var first = head;
        var second = head;

        while (second.next != null && second.next.next != null) {
            first = first.next;
            second = second.next.next;
            if (first == second) {
                break;
            }
        }
        if (second.next == null || second.next.next == null) return null;

        first = head;
        while (first != second) {
            first = first.next;
            second = second.next;
        }
        return first;
    }
}
