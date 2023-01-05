import java.util.LinkedList;

public class SolutionInPlace {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<TreeNode> roots = new LinkedList<>();

        TreeNode newRoot = null;
        TreeNode previousRoot = null;
        stack.push(root);
        while (!stack.isEmpty()) {
            var node = stack.pop();
            if ((newRoot == null) && (node.val<=high) && (node.val>=low)) {
                newRoot = node;
            }

            if (!roots.isEmpty()) previousRoot = roots.pop();
            if (previousRoot != null) {
                if (node.val < low) {
                    previousRoot.left = node.right;
                    if (node.right != null) {
                        stack.push(node.right);
                        roots.push(previousRoot);
                    }
                } else if (node.val > high) {
                    previousRoot.right = node.left;
                    if (node.left != null) {
                        stack.push(node.left);
                        roots.push(previousRoot);
                    }
                } else {
                    if (node.right != null) {
                        stack.push(node.right);
                        roots.push(node);
                    }
                    if (node.left != null) {
                        stack.push(node.left);
                        roots.push(node);
                    }
                }
            } else {
                if (node.val < low) {
                    if (node.right != null) {
                        stack.push(node.right);
                    }
                } else if (node.val > high) {
                    if (node.left != null) {
                        stack.push(node.left);
                    }
                } else {
                    if (node.right != null) {
                        stack.push(node.right);
                        roots.push(node);
                    }
                    if (node.left != null) {
                        stack.push(node.left);
                        roots.push(node);
                    }
                }
            }
        }

        return newRoot;
    }
}
