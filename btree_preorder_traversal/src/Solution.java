import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        if (root == null) return values;

        LinkedList<TreeNode> stack = new LinkedList<>();
        while (true) {
            while (root != null) {
                values.add(root.val);
                stack.push(root);
                root = root.left;
            }
            if (stack.isEmpty()) break;

            root = stack.pop();
            root = root.right;
        }
        return values;
    }
}
