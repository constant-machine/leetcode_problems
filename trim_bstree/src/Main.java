public class Main {

    public static void main(String... args) {
        SolutionInPlace sol = new SolutionInPlace();
    }

    /*
    [1,null,2,3]
     */
    private static TreeNode prepTree1() {
        TreeNode two = new TreeNode(2, new TreeNode(3), null);
        return new TreeNode(1, null, two);
    }

    /*
    [2,3,null,1]
     */
    private static TreeNode prepTree2() {
        TreeNode three = new TreeNode(3, new TreeNode(1), null);
        return new TreeNode(2, three, null);
    }

    /*
    [2,null,2]
     */
    private static TreeNode prepTree3() {
        TreeNode two = new TreeNode(2, null, null);
        return new TreeNode(2, null, two);
    }

    /*
    [3,1,2]
     */
    private static TreeNode prepTree4() {
        TreeNode one = new TreeNode(1, null, null);
        TreeNode two = new TreeNode(2, null, null);
        return new TreeNode(3, one, two);
    }
}
