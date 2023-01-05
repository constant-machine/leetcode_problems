import java.util.LinkedList;

public class Solution {

  public int rangeSumBST(TreeNode root, int low, int high) {
    LinkedList<TreeNode> stack = new LinkedList<>();
    int sum = 0;

    while(true) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
      if (stack.isEmpty()) break;
      root = stack.pop();

      if ((root.val>=low) && (root.val<=high)) sum+=root.val;

      root = root.right;
    }

    return sum;
  }
}
