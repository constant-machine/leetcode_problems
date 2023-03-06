public class Main {
    public static void main(String[] args) {
        var sol  = new IterativeSolution();
        var num = sol.numIslands(new char[][] {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}});
        assert num == 1;
        
        var sol1 = new IterativeSolution();
        num = sol1.numIslands(new char[][] {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}});
        assert num == 3;
    }
}