public class Main {
    public static void main(String[] args) {
        var sol = new BuildTreeThenSearchCycleIterativeSolution();
        System.out.println(sol.canFinish(2, new int[][] {{1,0}})); //true

        System.out.println(sol.canFinish(2, new int[][] {{1,0}, {0,1}})); //false

        System.out.println(sol.canFinish(4, new int[][]{{2, 0}, {1, 0}, {3, 1}, {3, 2}, {1, 3}})); //false

        System.out.println(sol.canFinish(5, new int[][]{{1, 4}, {2, 4}, {3, 1}, {3, 2}})); //true
    }
}