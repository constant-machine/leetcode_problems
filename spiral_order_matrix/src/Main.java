public class Main {

    public static void main(String[] args) {
        var sol = new Solution();

        var res = sol.spiralOrder(new int[][]{{1,2,3}, {8,9,4}, {7,6,5}});
        res.forEach(System.out::print);
        System.out.println();
        System.out.println("----------------------------");

        res = sol.spiralOrder(new int[][]{{1,2,3}, {6,5,4}});
        res.forEach(System.out::print);
        System.out.println();
        System.out.println("----------------------------");

        res = sol.spiralOrder(new int[][]{{1,2}, {6,3}, {5,4}});
        res.forEach(System.out::print);
        System.out.println();
        System.out.println("----------------------------");
    }
}