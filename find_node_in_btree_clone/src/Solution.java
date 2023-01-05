import java.util.LinkedList;

public class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<TreeNode> stackCloned = new LinkedList<>();
        TreeNode targetCloned = null;

        stack.push(original);
        stackCloned.push(cloned);
        while(!stack.isEmpty()) {
            var node = stack.pop();
            var nodeCloned = stackCloned.pop();
            if (node == target) {
                targetCloned = nodeCloned;
            }

            if (node.right != null) {
                stack.push(node.right);
                stackCloned.push(nodeCloned.right);
            }
            if (node.left != null) {
                stack.push(node.left);
                stackCloned.push(nodeCloned.left);
            }
        }
        return targetCloned;
    }
}
