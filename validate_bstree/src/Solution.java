import java.util.LinkedList;

public class Solution {

    public boolean isValidBST(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        boolean isValid = true;

        TreeNode previous = null;
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (stack.isEmpty()) break;
            TreeNode node = stack.pop();
            if (previous != null) {
                if (previous.val >= node.val) isValid = false;
            }
            previous = node;
            root = node.right;
        }
        return isValid;
    }
}
