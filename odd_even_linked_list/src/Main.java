public class Main {
  public static void main(String[] args) {
    var sol = new Solution();

//    var five = new ListNode(5, null);
    var four = new ListNode(4, null);
    var three = new ListNode(3, four);
    var two = new ListNode(2, three);
    var head = new ListNode(1, two);
    var res = sol.oddEvenList(head);
    System.out.println(res);
  }
}