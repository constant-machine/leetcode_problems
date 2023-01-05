import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        if (root == null) return values;

        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<TreeNode> secondStack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
            secondStack.push(node);
        }
        while (!secondStack.isEmpty()) {
            values.add(secondStack.pop().val);
        }
        return values;
    }
}
