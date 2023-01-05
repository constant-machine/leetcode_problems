import java.util.Arrays;

public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        int length = calcLength(head);
        int[] array = getArray(head, length);
        TreeNode treeHead = convertToTree(array);
        return treeHead;
    }

    private TreeNode convertToTree(int[] array) {
        if (array.length == 0) return null;
        if (array.length == 1) return new TreeNode(array[0]);
        if (array.length == 2) {
            TreeNode root = new TreeNode(array[0]);
            root.right = new TreeNode(array[1]);
            return root;
        }
        int mid = array.length/2;
        TreeNode root = new TreeNode(array[mid]);
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid + 1, array.length);
        root.left = convertToTree(left);
        root.right = convertToTree(right);
        return root;
    }

    private TreeNode convertToTreeIterative(int[] array) {
        while () {
            int mid = array.length/2;
            int[] left = Arrays.copyOfRange(array, 0, mid);
            int[] right = Arrays.copyOfRange(array, mid + 1, array.length);
        }
    }

    private int calcLength(ListNode head) {
        ListNode index = head;
        int length = 0;
        while (index != null) {
            length++;
            index = index.next;
        }
        return length;
    }

    private int[] getArray(ListNode head, int length) {
        int[] array = new int[length];
        ListNode index = head;
        int i = 0;
        while (index != null) {
            array[i] = index.val;
            i++;
            index = index.next;
        }
        return array;
    }
}
