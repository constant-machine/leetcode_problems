public class Main {
  public static void main(String[] args) {
    var sol = new Solution();
    var res = sol.findMinArrowShots(new int[][]{{1, 3}, {3, 4}, {2, 3}, {6, 7}, {5, 9}});
    System.out.println(res);

    res = sol.findMinArrowShots(new int[][]{{10,16},{2,8},{1,6},{7,12}});
    System.out.println(res);
  }
}