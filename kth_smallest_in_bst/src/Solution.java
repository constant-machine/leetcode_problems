import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = collectToListDFSIterative(root);
        list.sort(Comparator.naturalOrder());
        return list.get(k-1);
    }

    private List<Integer> collectToListDFSIterative(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            values.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return values;
    }
}
