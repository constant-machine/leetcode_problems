public class Main {
  public static void main(String[] args) {
    var sol = new Solution();
    var res = sol.mergeKLists(new ListNode[]{new ListNode(4), null, new ListNode(1), null, new ListNode(2), new ListNode(5)});
    System.out.println(res);
  }
}