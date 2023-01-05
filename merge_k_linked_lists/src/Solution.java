import java.util.Arrays;

public class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists.length == 0) return null;

    sortWithNullsAtEnd(lists);
    ListNode result = new ListNode();
    ListNode tail = result;
    while (lists[0] != null) {

      lists = cutNulls(lists);
      int currMax = lists[lists.length-1].val;

      for (int i = 0; i < lists.length; i++) {
        if (i < lists.length - 1) {
          while ((lists[i] != null) && (lists[i].val <= lists[i+1].val)) {
            tail.next = new ListNode(lists[i].val);
            tail = tail.next;

            lists[i] = lists[i].next;
          }
          if ((lists[i] != null) && (lists[i].val <= currMax)) break;
        } else {
          tail.next = new ListNode(lists[i].val);
          tail = tail.next;

          lists[i] = lists[i].next;
        }
      }
      sortWithNullsAtEnd(lists);
    }

    result = result.next;
    return result;
  }

  private void sortWithNullsAtEnd(ListNode[] lists) {
    Arrays.sort(lists, (o1, o2) -> {
      if (o1 == null && o2 == null) return 0;
      if (o1 == null) return 1;
      if (o2 == null) return -1;
      return Integer.compare(o1.val, o2.val);
    });
  }

  private ListNode[] cutNulls(ListNode[] lists) {
    int length = 0;
    for (int i = 0; i < lists.length; i++) {
      if (lists[i] != null) length++;
    }
    return Arrays.copyOfRange(lists, 0, length);
  }
}
