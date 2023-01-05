public class Main {
  public static void main(String[] args) {
    var sol = new Solution();
    var res = sol.productExceptSelf(new int[] {1,2,3,4});
    for (int i = 0; i < res.length; i++) {
      System.out.print(res[i] + " ");
    }
    System.out.println("");
  }
}