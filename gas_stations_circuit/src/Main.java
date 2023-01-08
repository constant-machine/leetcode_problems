public class Main {
  public static void main(String[] args) {
    var sol = new Solution();
    var res = sol.canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2});
    System.out.println(res); //3

    res = sol.canCompleteCircuit(new int[]{0, 0, 1}, new int[]{0, 0, 1});
    System.out.println(res); //0

    res = sol.canCompleteCircuit(new int[]{0, 4, 0}, new int[]{1, 2, 1});
    System.out.println(res); //1
  }
}