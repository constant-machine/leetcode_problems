public class Main {

    public static void main(String... args) {
        Solution sol = new Solution();
        var list = sol.preorderTraversal(prepTree1());
        System.out.println(list); //expected 1,2,3

        list = sol.preorderTraversal(prepTree2());
        System.out.println(list); //expected 2,3,1

        list = sol.preorderTraversal(prepTree3());
        System.out.println(list); //expected 2,2
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
}
