public class Main {

    public static void main(String... args) {
        Solution sol = new Solution();
        int[][] grid = new int[][]{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        sol.gameOfLife(grid);
    }
}
