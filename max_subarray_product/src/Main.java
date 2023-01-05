public class Main {
    public static void main(String[] args) {
        var sol = new SolutionDP();
        var sol1 = new SolutionFast();
        System.out.println(sol.maxProduct(new int[] {2,3,-2,4}));
        System.out.println(sol1.maxProduct(new int[] {2,3,-2,4}));

        System.out.println();
        System.out.println(sol.maxProduct(new int[] {-2,0,-1}));
        System.out.println(sol1.maxProduct(new int[] {-2,0,-1}));

        System.out.println();
        System.out.println(sol.maxProduct(new int[] {-2,2,-1}));
        System.out.println(sol1.maxProduct(new int[] {-2,2,-1}));

        System.out.println();
        System.out.println(sol.maxProduct(new int[] {0,2}));
        System.out.println(sol1.maxProduct(new int[] {0,2}));

        System.out.println();
        System.out.println(sol.maxProduct(new int[] {-1,-2,-9,-6}));
        System.out.println(sol1.maxProduct(new int[] {-1,-2,-9,-6}));
    }
}