public class Main {
    public static void main(String[] args) {
        var sol = new RecursiveSolution();
        var res = sol.pacificAtlantic(new int[][] {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}});
        System.out.println(res); // [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]]

        res = sol.pacificAtlantic(new int[][] {{1}});
        System.out.println(res); // [[0, 0]]

        var sol1 = new IterativeSolution();
        res = sol1.pacificAtlantic(new int[][] {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}});
        System.out.println(res); // [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]]

        res = sol1.pacificAtlantic(new int[][] {{1}});
        System.out.println(res); // [[0, 0]]
    }
}