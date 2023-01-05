import java.util.LinkedList;

public class Solution  {

    public String removeDuplicates(String s) {
        if (s.length() == 1) return s;

        char[] chars = s.toCharArray();
        LinkedList<Character> stack = new LinkedList<>();

        stack.push(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            var prev = stack.pop();
            var curr = chars[i];
            if (!prev.equals(curr)) {
                stack.push(prev);
                stack.push(curr);
            }
            if (stack.isEmpty() && (i < chars.length-1)) {
                stack.push(chars[++i]);
            }
        }

        char[] result = new char[stack.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.get(stack.size() - i - 1);
        }

        return new String(result);
    }
}
